package cn.xyf.algorithm.monotonicqueue.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/16 13:25
 */

public class Leetcode239 {

    private static class MonotonicQueue {

        private LinkedList<Integer> deque = new LinkedList<>();

        public Integer peek() {
            return deque.peekFirst();
        }

        public void poll() {
            deque.pollFirst();
        }

        public void offer(Integer t) {
            while (!deque.isEmpty() && deque.peekLast() < t) {
                deque.pollLast();
            }
            deque.offerLast(t);
        }

        @Override
        public String toString() {
            return deque.toString();
        }

    }

    // 每次向单调递减队列加入元素，队头元素即为滑动窗口最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        MonotonicQueue queue = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            // 检查队列头部元素，超过滑动窗口范围要移除
            if (i >= k && queue.peek() == nums[i - k]) {
                queue.poll();
            }
            int num = nums[i];
            queue.offer(num);
            if (i >= k - 1) {
                list.add(queue.peek());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
