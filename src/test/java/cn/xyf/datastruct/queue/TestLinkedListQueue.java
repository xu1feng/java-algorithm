package cn.xyf.datastruct.queue;

import org.junit.Test;

/**
 * @author: Xuyifeng
 * @date: 2025/1/21 11:46
 * @description:
 */

public class TestLinkedListQueue {

    @Test
    public void offer() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

    }

    @Test
    public void peek() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        System.out.println(queue.peek());
        queue.offer(2);
        System.out.println(queue.peek());
    }

    @Test
    public void poll() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        System.out.println(queue.poll());
        queue.offer(2);
        System.out.println(queue.poll());
    }

    @Test
    public void offerLimit() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.offer(4));
        System.out.println(queue.offer(5));
    }

}
