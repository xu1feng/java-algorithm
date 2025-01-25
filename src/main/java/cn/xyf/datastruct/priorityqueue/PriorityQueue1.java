package cn.xyf.datastruct.priorityqueue;

import cn.xyf.datastruct.queue.Queue;

/**
 * @author Xuyifeng
 * @description 优先级队列 - 基于无序数组实现
 * @date 2025/1/23 10:10
 */

/*
    优先级队列       一端进，另一端出        按优先级出队
    普通队列        一端进，另一端出        FIFO
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue1(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[size++] = value;
        return true;
    }

    // 返回优先级最高的索引值
    private int getMaxPriority() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
    }

    @Override // O(n)
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int maxPriority = getMaxPriority();
        E removed = (E) array[maxPriority];
        remove(maxPriority);
        return removed;
    }

    private void remove(int index) {
        // 删除的不是最后一个元素
        if (index < size - 1) {
            // 移动
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        size--;
        array[size] = null; // help GC
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int maxPriority = getMaxPriority();
        return (E) array[maxPriority];
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
