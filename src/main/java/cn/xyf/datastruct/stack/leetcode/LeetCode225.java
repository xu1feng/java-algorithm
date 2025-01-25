package cn.xyf.datastruct.stack.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xuyifeng
 * @description 用队列实现栈
 * @date 2025/1/22 16:01
 */

public class LeetCode225 {

    private static class MyStack {

        Queue<Integer> queue = new LinkedList<>();
        private int size = 0;

        public MyStack() {

        }

        // 将 新加入元素 前面的所有元素从队列头移动到队列尾
        public void push(int x) {
            queue.offer(x);
//            while (!queue.isEmpty() && queue.peek() != x) {
//                queue.offer(queue.poll());
//            }
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
            size++;
        }

        // 直接移除队列头元素
        public int pop() {
            size--;
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

    }

}
