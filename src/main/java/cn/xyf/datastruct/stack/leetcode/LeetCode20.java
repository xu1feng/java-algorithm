package cn.xyf.datastruct.stack.leetcode;

import cn.xyf.datastruct.stack.ArrayStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: Xuyifeng
 * @date: 2025/1/22 10:18
 * @description: 有效的括号
 */

public class LeetCode20 {

    /*
        (   [
        )   ]
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                // 第一个字符为 右括号 的情况
                if (!stack.isEmpty() && c == stack.peek()) {
                    // 与栈顶括号相等，成对
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([{}])"));
        System.out.println(isValid("(]"));
    }

}
