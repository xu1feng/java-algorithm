package cn.xyf.datastruct.stack.leetcode;

import java.util.LinkedList;

/**
 * @author: Xuyifeng
 * @date: 2025/1/22 13:47
 * @description: 中缀表达式转后缀表达式
 */

public class InfixToSuffix {

    /*
        1. 遇到非运算符 直接拼串
        2. 遇到 + - * /
            - 它的优先级比栈顶运算符高，入栈
            - 否则把栈里优先级 >= 它 的都出栈，，它再入栈
        3. 遍历完成，栈里剩余运算符依次出栈
        4. 带()的情况
            - 左括号直接入栈，左括号优先级为0
            - 右括号就把栈里到左括号为止的所有运算符出栈
     */

    private static int priority(char c) {
        return switch (c) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            case '(' -> 0;
            default -> throw new IllegalArgumentException("不合法的运算符");
        };
    }

    public static String infixToSuffix(String exp) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '+', '-', '*', '/' -> {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (priority(c) > priority(stack.peek())) {
                            stack.push(c);
                        } else {
                            while (!stack.isEmpty() && (stack.peek()) >= priority(c)) {
                                sb.append(stack.poll());
                            }
                            stack.push(c);
                        }
                    }
                }
                case '(' -> {
                    stack.push(c);
                }
                case ')' -> {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    // 左括号移除
                    stack.pop();
                }
                default -> {
                    sb.append(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(infixToSuffix("a+b"));
        System.out.println(infixToSuffix("a+b-c"));
        System.out.println(infixToSuffix("a+b*c"));
        System.out.println(infixToSuffix("a*b-c"));
        System.out.println(infixToSuffix("a*(b+c)"));
    }

}
