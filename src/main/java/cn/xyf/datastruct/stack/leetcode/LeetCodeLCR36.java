package cn.xyf.datastruct.stack.leetcode;

import java.util.Stack;

/**
 * @author: Xuyifeng
 * @date: 2025/1/22 10:39
 * @description: 逆波兰表达式求值
 */

public class LeetCodeLCR36 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer a, b;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default: // 数字
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

    }

}
