package cn.xyf.datastruct.queue;

import java.util.Iterator;

/**
 * @author: Xuyifeng
 * @date: 2025/1/21 15:20
 * @description: 队列 - 环形数组实现2
 */

/**
 * 用 size 辅助判断空满
 * @param <E> 队列中元素类型
 */
public class CircularArrayQueue2<E> implements Queue<E>, Iterable<E> {

    private E[] array;
    private int head = 0; // 头指针
    private int tail = 0; // 尾指针
    private int size = 0; // 元素个数

    public CircularArrayQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        head = (head + 1) % array.length;
        size--;
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
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                count++;
                return value;
            }
        };
    }
}
