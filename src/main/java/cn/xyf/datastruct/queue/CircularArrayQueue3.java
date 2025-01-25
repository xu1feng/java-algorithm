package cn.xyf.datastruct.queue;

import java.util.Iterator;

/**
 * @author: Xuyifeng
 * @date: 2025/1/21 15:26
 * @description: 队列 - 环形数组实现3
 */

public class CircularArrayQueue3<E> implements Queue<E>, Iterable<E> {
    private final E[] array;
    private int head = 0; // 头指针
    private int tail = 0; // 尾指针

    public CircularArrayQueue3(int capacity) {
        array = (E[])new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[(int) (Integer.toUnsignedLong(tail) % array.length)] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[(int) (Integer.toUnsignedLong(head) % array.length)];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[(int) Integer.toUnsignedLong(head) % array.length];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
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
                E value = array[(int) Integer.toUnsignedLong(p) % array.length];
                p++;
                return value;
            }
        };
    }
}
