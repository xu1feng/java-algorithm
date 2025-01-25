package cn.xyf.datastruct.deque;

import org.junit.Test;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/1/22 17:17
 */

public class TestCircularArrayDeque {

    @Test
    public void offer() {
        CircularArrayDeque<Integer> deque = new CircularArrayDeque<>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        System.out.println(deque.offerFirst(6));
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
    }

}
