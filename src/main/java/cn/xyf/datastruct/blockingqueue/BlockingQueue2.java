package cn.xyf.datastruct.blockingqueue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Xuyifeng
 * @description 阻塞队列 - 双锁实现
 * @date 2025/1/23 17:39
 */

public class BlockingQueue2<E> implements IBlockingQueue<E> {

    private final E[] array;
    private int head;
    private int tail;
    private AtomicInteger size = new AtomicInteger();

    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private ReentrantLock tailLock = new ReentrantLock();
    private Condition tailWaits = tailLock.newCondition();
    private ReentrantLock headLock = new ReentrantLock();
    private Condition headWaits = headLock.newCondition();

    @Override
    public void offer(E e) throws InterruptedException {
        tailLock.lockInterruptibly();
        int c; // 添加前的元素个数
        try {
            // 1. 队列满则等待
            while (isFull()) {
                tailWaits.await();
            }

            // 2. 队列不满则入队
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }

            // 3. 修改 size
            c = size.getAndIncrement(); // 先获取旧的值再自增，c获取的是旧的值
            if (c + 1 < array.length) {
                tailWaits.signal();
            }
            /*
                size++ 做三件事
                1. 读取成员变量 size 的值
                2. 自增
                3. 结果写回成员变量 size
             */

        } finally {
            tailLock.unlock();
        }

        // 4. 通知等待非空的线程
        if (c == 0) {
            headLock.lockInterruptibly();
            try {
                headWaits.signal(); // 必须和它配对的锁成对使用
            } finally {
                headLock.unlock();
            }
        }
    }

    @Override
    public E poll() throws InterruptedException {
        E e;
        int c; // 取走前的元素个数
        headLock.lockInterruptibly();
        try {
            // 1. 队列为空则等待
            while (isEmpty()) {
                headWaits.await();
            }

            // 2. 非空则取走元素
            e = array[head];
            array[head] = null; // help GC
            if (++head == array.length) {
                head = 0;
            }

            // 3. 修改 size
            c = size.getAndDecrement(); // size--
            if (c > 1) {
                headWaits.signal();
            }
            /*
                size-- 做三件事
                1. 读取成员变量 size 的值
                2. 自减
                3. 结果写回成员变量 size
             */
        } finally {
            headLock.unlock();
        }
        // 4. 队列从 满 -> 不满 时, 由 poll 唤醒等待不满的 offer 线程
        if (c == array.length) {
            tailLock.lockInterruptibly();
            try {
                tailWaits.signal();
            } finally {
                tailLock.unlock(); // 必须和它配对的锁成对使用
            }
        }

        return e;
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        return false;
    }

    private boolean isFull() {
        return size.get() == array.length;
    }

    private boolean isEmpty() {
        return size.get() == 0;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue2<String> queue = new BlockingQueue2<>(3);
        queue.offer("元素1");
        queue.offer("元素2");

        new Thread(() -> {
            try {
                queue.offer("元素3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "offer").start();

        new Thread(() -> {
            try {
                queue.poll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "poll").start();
    }

}
