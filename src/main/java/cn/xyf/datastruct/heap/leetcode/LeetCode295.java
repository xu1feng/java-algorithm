package cn.xyf.datastruct.heap.leetcode;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 数据流的中位数
 * @date 2025/1/24 12:05
 */

public class LeetCode295 {

    /**
     * 为了保证两边数据量的平衡
     * <ul>
     *     <li>两边个数一样时，左边个数加一</li>
     *     <li>两边个数不一样时，右边个数加一</li>
     * </ul>
     * 但是，随便一个数能直接加入吗？
     * <ul>
     *     <li>左边个数加一时，把新元素加在右边，弹出右边最小的加入左边</li>
     *     <li>右边个数加一时，把新元素加在左边，弹出左边最大的加入右边</li>
     * </ul>
     */

    /*
        大顶堆->   <-小顶堆
          2 1 3   7 8 9
     */

    private static class MedianFinder {

        private Heap left = new Heap(10, true);
        private Heap right = new Heap(10, false);

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (left.size() == right.size()) {
                right.offer(num);
                left.offer(right.poll());
            } else {
                left.offer(num);
                right.offer(left.poll());
            }
        }

        /**
         * <ul>
         *     <li>两边数据一致, 左右各取堆顶元素求平均</li>
         *     <li>左边多一个, 取左边元素</li>
         * </ul>
         */
        public double findMedian() {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return left.peek();
            }
        }

    }

    private static class Heap {
        int[] array;
        int size;
        boolean max;

        public int size() {
            return size;
        }

        public Heap(int capacity, boolean max) {
            this.array = new int[capacity];
            this.max = max;
        }

        /**
         * 获取堆顶元素
         *
         * @return 堆顶元素
         */
        public int peek() {
            return array[0];
        }

        /**
         * 删除堆顶元素
         *
         * @return 堆顶元素
         */
        public int poll() {
            int top = array[0];
            swap(0, size - 1);
            size--;
            down(0);
            return top;
        }

        /**
         * 删除指定索引处元素
         *
         * @param index 索引
         * @return 被删除元素
         */
        public int poll(int index) {
            int deleted = array[index];
            swap(index, size - 1);
            size--;
            down(index);
            return deleted;
        }

        /**
         * 替换堆顶元素
         *
         * @param replaced 新元素
         */
        public void replace(int replaced) {
            array[0] = replaced;
            down(0);
        }

        /**
         * 堆的尾部添加元素
         *
         * @param offered 新元素
         */
        public void offer(int offered) {
            if (size == array.length) {
                grow();
            }
            up(offered);
            size++;
        }

        private void grow() {
            int capacity = size + (size >> 1);
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0,
                    newArray, 0, size);
            array = newArray;
        }

        // 将 offered 元素上浮: 直至 offered 小于父元素或到堆顶
        private void up(int offered) {
            int child = size;
            while (child > 0) {
                int parent = (child - 1) / 2;
                boolean cmp = max ? offered > array[parent] : offered < array[parent];
                if (cmp) {
                    array[child] = array[parent];
                } else {
                    break;
                }
                child = parent;
            }
            array[child] = offered;
        }

        public Heap(int[] array, boolean max) {
            this.array = array;
            this.size = array.length;
            this.max = max;
            heapify();
        }

        // 建堆
        private void heapify() {
            // 如何找到最后这个非叶子节点  size / 2 - 1
            for (int i = size / 2 - 1; i >= 0; i--) {
                down(i);
            }
        }

        // 将 parent 索引处的元素下潜: 与两个孩子较大者交换, 直至没孩子或孩子没它大
        private void down(int parent) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int min = parent;
            if (left < size && (max ? array[left] > array[min] : array[left] < array[min])) {
                min = left;
            }
            if (right < size && (max ? array[right] > array[min] : array[right] < array[min])) {
                min = right;
            }
            if (min != parent) { // 找到了更大的孩子
                swap(min, parent);
                down(min);
            }
        }

        // 交换两个索引处的元素
        private void swap(int i, int j) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }

    public static void main(String[] args) {
        MedianFinder test = new MedianFinder();
        test.addNum(2);
        test.addNum(3);
        System.out.println(test.findMedian());
    }

}
