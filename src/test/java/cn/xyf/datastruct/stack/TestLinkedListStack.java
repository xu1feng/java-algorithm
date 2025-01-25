package cn.xyf.datastruct.stack;

import org.junit.Test;

/**
 * @author: Xuyifeng
 * @date: 2025/1/21 17:46
 * @description:
 */

public class TestLinkedListStack {

    @Test
    public void push() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.push(4));
    }

    @Test
    public void pop() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
