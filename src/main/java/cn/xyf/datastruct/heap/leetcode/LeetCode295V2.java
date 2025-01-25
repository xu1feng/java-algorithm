package cn.xyf.datastruct.heap.leetcode;

import java.util.PriorityQueue;

/**
 * @author Xuyifeng
 * @description 数据流的中位数 - 优先级队列
 * @date 2025/1/24 14:46
 */

public class LeetCode295V2 {

    private static class MedianFinder {

        // 大顶堆
        private PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        // 默认是小顶堆
        private PriorityQueue<Integer> right = new PriorityQueue<>();

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

        public double findMedian() {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return left.peek();
            }
        }
    }

}
