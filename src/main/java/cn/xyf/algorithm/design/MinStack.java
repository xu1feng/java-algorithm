package cn.xyf.algorithm.design;

import java.util.LinkedList;

/**
 * @author Xuyifeng
 * @description 最小栈 Leetcode155
 * @date 2025/2/17 18:27
 */

public class MinStack {

    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> min = new LinkedList<>();

    public MinStack() {
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        min.push(Math.min(val, min.peek()));
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

}
