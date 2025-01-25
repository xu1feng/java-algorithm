package cn.xyf.datastruct.priorityqueue.leetcode;

import cn.xyf.datastruct.priorityqueue.Entry;
import cn.xyf.datastruct.priorityqueue.Priority;

/**
 * @author Xuyifeng
 * @description 合并 K 个升序链表 - 小顶堆方法
 * @date 2025/1/23 13:58
 */

public class LeetCode23 {

    /*
                  p
        1->4->5->null

                  p
        1->3->4->null

               p
        2->6->null

        小顶堆     4 5 6
        空链表     1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
     */

    public ListNode mergeKLists(ListNode[] lists) {
        MinHeap minHeap = new MinHeap(lists.length);
        // 将链表的头节点加入小顶堆
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        // 不断从堆顶移除最小元素，加入新链表
        ListNode sentinel = new ListNode(-1, null);
        ListNode p = sentinel;
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            p.next = min;
            p = min;

            if (min.next != null) {
                minHeap.offer(min.next);
            }
        }
        return sentinel.next;
    }

    private static class MinHeap {
        ListNode[] array;
        int size;

        public MinHeap(int capacity) {
            array = new ListNode[capacity];
        }

        public boolean offer(ListNode offered) {
            if (isFull()) {
                return false;
            }
            int child = size++;
            int parent = (child - 1) / 2;
            while (child > 0 && offered.val < array[parent].val) {
                array[child] = array[parent];
                child = parent;
                parent = (child - 1) / 2;
            }
            array[child] = offered;
            return true;
        }

        private void down(int parent) {
            int left = 2 * parent + 1;
            int right = left + 1;
            int min = parent; // 假设父节点值最小
            if (left < size && array[left].val < array[min].val) {
                min = left;
            }
            if (right < size && array[right].val < array[min].val) {
                min = right;
            }
            if (min != parent) { // 有孩子比父亲大
                swap(min, parent);
                down(min);
            }
        }

        private void swap(int i, int j) {
            ListNode t = array[i];
            array[i] = array[j];
            array[j] = t;
        }

        public ListNode poll() {
            if (isEmpty()) {
                return null;
            }
            swap(0, size - 1);
            size--;
            ListNode node = array[size];
            array[size] = null;

            // 下潜
            down(0);

            return node;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == array.length;
        }
    }

}
