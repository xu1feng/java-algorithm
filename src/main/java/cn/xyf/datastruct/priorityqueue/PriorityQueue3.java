package cn.xyf.datastruct.priorityqueue;

import cn.xyf.datastruct.queue.Queue;

/**
 * @author Xuyifeng
 * @description 优先级队列 - 基于堆实现
 * @date 2025/1/23 11:15
 */

public class PriorityQueue3<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue3(int capacity) {
        array = new Priority[capacity];
    }

    /*
        1. 入队新元素，加入到数组末尾 （索引位置 child)
        2. 不断比较新加入元素与它父节点(parent)优先级
            - 如果父节点优先级低，则向下移动，并找到下一个 parent
            - 直至父节点优先级更高或 child == 0 为止
     */
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && value.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = value;
        return true;
    }

    // 移除优先级最高的元素
    /*
        1. 交换堆顶和尾部元素，让尾部元素出队
        2. （下潜）
            - 从堆顶开始，将父元素与两个孩子较大者交换
            - 直到父元素大于两个孩子，或没有孩子为止
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0, size - 1);
        size--;
        Priority priority = array[size];
        array[size] = null;

        // 下潜
        down(0);

        return (E) priority;
    }

    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent; // 假设父节点优先级最高
        if (left < size && array[left].priority() > array[max].priority()) {
            max = left;
        }
        if (right < size && array[right].priority() > array[max].priority()) {
            max = right;
        }
        if (max != parent) { // 有孩子比父亲大
            swap(max, parent);
            down(max);
        }
    }

    private void swap(int i, int j) {
        Priority t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
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
