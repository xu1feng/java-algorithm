package cn.xyf.代码随想录.栈与队列.用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/23 21:51
 */

public class Leetcode225 {
    class MyStack {

        Queue<Integer> queue = new LinkedList<>();
        private int size = 0;

        public MyStack() {

        }

        // 将新加入的元素前面的所有元素从队列头移动到队列尾
        public void push(int x) {
            queue.offer(x);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
            size++;
        }

        // 直接移除队列的元素
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
