package cn.xyf.datastruct.heap.leetcode;

/**
 * @author Xuyifeng
 * @description 数组中的第 k 个最大元素
 * @date 2025/1/24 11:33
 */

/**
 * 解题思路
 * <ol>
 *     <li>向小顶堆放入前 k 个元素</li>
 *     <li>剩余元素</li>
 *     <ul>
 *         <li>若 <= 堆顶元素，则略过</li>
 *         <li>若 > 堆顶元素，则替换堆顶元素</li>
 *     </ul>
 *     <li>这样小顶堆始终保留的是到目前为止，<b>前 K 大</b>的元素</li>
 *     <li>循环结束，堆顶元素即为<b>第 K 大</b>元素</li>
 * </ol>
 */
public class LeetCode215 {

    public static int findKthLargest(int[] nums, int k) {
        MinHeap minHeap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.replace(nums[i]);
            }
        }
        return minHeap.peek();
    }

    private static class MinHeap {
        int[] array;
        int size;

        public MinHeap(int capacity) {
            array = new int[capacity];
        }

        public MinHeap(int[] array) {
            this.array = array;
            this.size = array.length;
            buildHeap();
        }

        /**
         * 建堆
         * 1. 找到最后一个非叶子节点
         * 2. 从后向前，对每个节点执行下潜
         */
        public void buildHeap() {
            // 如何找到最后这个非叶子节点 size / 2 - 1 -> 适用于索引从 0 开始的堆
            for (int i = size / 2 - 1; i >= 0; i--) {
                down(i);
            }
        }

        /**
         * 将 parent 索引处的元素下潜：与两个孩子较大者交换，直至没孩子或孩子没它大
         *
         * @param parent 要下潜的元素索引
         */
        public void down(int parent) {
            int left = 2 * parent + 1;
            int right = left + 1;
            int min = parent;
            if (left < size && array[left] < array[min]) {
                min = left;
            }
            if (right < size && array[right] < array[min]) {
                min = right;
            }
            if (min != parent) { // 找到了更大的孩子
                swap(min, parent);
                down(min);
            }
        }

        /**
         * 交换
         *
         * @param i
         * @param j
         */
        public void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        /**
         * 删除堆顶元素
         * 1. 跟最后一个元素交换
         * 2. 移除最后一个元素
         * 3. 将新堆顶元素进行下潜
         *
         * @return 堆顶元素
         */
        public int poll() {
            if (isEmpty()) {
                return -1;
            }
            int top = array[0];
            swap(0, size - 1);
            size--;
            down(0);
            return top;
        }

        /**
         * 删除指定索引处元素
         * 1. 与最后一个元素交换
         * 2. 移除最后一个元素
         * 3. 将新交换的元素进行下潜
         *
         * @param index 索引
         * @return 被删除元素
         */
        public int poll(int index) {
            if (isEmpty()) {
                return -1;
            }
            int removed = array[index];
            swap(index, size - 1);
            size--;
            down(index);
            return removed;
        }

        /**
         * 获取堆顶元素
         *
         * @return 堆顶元素
         */
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return array[0];
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
         * @return 是否添加成功
         */
        public boolean offer(int offered) {
            if (isFull()) {
                return false;
            }
            up(offered);
            size++;
            return true;
        }

        /**
         * 将 offered 元素上浮：直至 offered 小于父元素或到堆顶
         *
         * @param offered
         */
        public void up(int offered) {
            int child = size;
            while (child > 0) {
                int parent = (child - 1) / 2;
                if (offered < array[parent]) {
                    array[child] = array[parent];
                } else {
                    break;
                }
                child = parent;
            }
            array[child] = offered;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == array.length;
        }
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

}
