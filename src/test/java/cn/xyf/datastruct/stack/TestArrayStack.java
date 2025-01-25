package cn.xyf.datastruct.stack;

import org.junit.Test;

/**
 * @author: Xuyifeng
 * @date: 2025/1/22 10:15
 * @description:
 */

public class TestArrayStack {

    @Test
    public void push() {
        ArrayStack<Object> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.push(4));
    }

    @Test
    public void pop() {
        ArrayStack<Object> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
