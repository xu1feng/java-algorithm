package cn.xyf.datastruct.stack.leetcode;

import java.util.Stack;

/**
 * @author Xuyifeng
 * @Description 用栈实现队列
 * @Date 2025/1/22 15:46
 */

public class LeetCode232 {

    /*
        队列头         队列尾
                       a b
        顶   底       底   顶
        s1                s2

        s2.push(a)
        s2.push(b)

        先把 s2 的所有元素移动到 s1
        s1.pop()

     */
    private static class MyQueue {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public MyQueue() {

        }

        // 向队列尾部添加
        public void push(int x) {
            s2.push(x);
        }

        public int pop() {
            if (s1.isEmpty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
            return s1.pop();
        }

        public int peek() {
            if (s1.isEmpty()) {
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
