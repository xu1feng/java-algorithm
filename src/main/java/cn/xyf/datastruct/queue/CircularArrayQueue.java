package cn.xyf.datastruct.queue;

import java.util.Iterator;

/**
 * @author: Xuyifeng
 * @date: 2025/1/21 14:58
 * @description: 队列 - 环形数组实现
 */

/**
 * 仅用 head，tail 判断空满，head、tail 即为索引值
 * @param <E> 队列中元素类型
 */
public class CircularArrayQueue<E> implements Queue<E>, Iterable<E> {

    private E[] array;
    private int head = 0; // 头指针
    private int tail = 0; // 尾指针

    public CircularArrayQueue(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        head = (head + 1) % array.length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                return value;
            }
        };
    }
}
