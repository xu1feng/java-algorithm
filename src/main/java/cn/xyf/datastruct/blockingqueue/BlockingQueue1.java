package cn.xyf.datastruct.blockingqueue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Xuyifeng
 * @description 阻塞队列 - 单锁实现
 * @date 2025/1/23 15:10
 */

public class BlockingQueue1<E> implements IBlockingQueue<E> {

    private final E[] array;
    private int head;
    private int tail;
    private int size;

    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    ReentrantLock lock = new ReentrantLock(); // 锁对象
    Condition headWaits = lock.newCondition(); // 条件变量对象
    Condition tailWaits = lock.newCondition(); // 条件变量对象 可以看成集合

    @Override
    public void offer(E e) throws InterruptedException { // poll 等待队列非空
        lock.lockInterruptibly(); // 加锁（可以在阻塞状态随时打断）
        try {
            while (isFull()) {
                // 满了该做的事，offer 线程阻塞
                tailWaits.await(); // 当成线程加入 tailWaits，并且让此线程阻塞
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
        } finally {
            lock.unlock(); // 解锁
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException { // 毫秒
        lock.lockInterruptibly(); // 加锁（可以在阻塞状态随时打断）
        try {
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()) {
                if (nanos <= 0) {
                    return false;
                }
                nanos = tailWaits.awaitNanos(nanos); // 最多等待多少纳秒  返回值 -> 剩余未等待时间
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
            return true;
        } finally {
            lock.unlock(); // 解锁
        }
    }

    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWaits.await();
            }
            E e = array[head];
            array[head] = null; // help GC
            if (++head == array.length) {
                head = 0;
            }
            size--;
            tailWaits.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    private boolean isFull() {
        return size == array.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue1<String> queue = new BlockingQueue1<>(3);
        queue.offer("任务1");

        new Thread(()->{
            try {
                queue.offer("任务2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "offer").start();

        new Thread(()->{
            try {
                System.out.println(queue.poll());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "poll").start();
    }

}
