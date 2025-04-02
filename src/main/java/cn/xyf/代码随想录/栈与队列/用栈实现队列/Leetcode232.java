package cn.xyf.代码随想录.栈与队列.用栈实现队列;

import java.util.Stack;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/23 21:30
 */

public class Leetcode232 {
    class MyQueue {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            s2.push(x);
        }

        public int pop() {
            if (s1.empty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
            return s1.pop();
        }

        public int peek() {
            if (s1.empty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
            return s1.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
