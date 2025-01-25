package cn.xyf.datastruct.priorityqueue;

import cn.xyf.datastruct.queue.Queue;

/**
 * @author Xuyifeng
 * @description 优先级队列 - 基于有序数组实现
 * @date 2025/1/23 10:50
 */

public class PriorityQueue2<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        insert(value);
        size++;
        return true;
    }

    // O(n)
    private void insert(E value) {
        int i = size - 1;
        while (i >= 0 && array[i].priority() > value.priority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E removed = (E) array[size - 1];
        size--;
        array[size] = null; // help GC
        return removed;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

}
