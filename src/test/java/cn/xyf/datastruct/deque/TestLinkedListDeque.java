package cn.xyf.datastruct.deque;

import org.junit.Test;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/1/22 16:44
 */

public class TestLinkedListDeque {

    @Test
    public void offer() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        System.out.println(deque.offerLast(6));
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
    }

}
