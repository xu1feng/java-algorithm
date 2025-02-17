package cn.xyf.algorithm.monotonicqueue;

import java.util.LinkedList;

/**
 * @author Xuyifeng
 * @description 单调递减队列
 * @date 2025/2/16 13:11
 */

public class MonotonicQueue {

    private LinkedList<Integer> deque = new LinkedList<>();

    public Integer peek() {
        return deque.peekFirst();
    }

    public void poll() {
        deque.pollFirst();
    }

    public void offer(Integer t) {
        while (!deque.isEmpty() && deque.peekLast() < t) {
            deque.pollLast();
        }
        deque.offerLast(t);
    }

    @Override
    public String toString() {
        return deque.toString();
    }

    public static void main(String[] args) {
        MonotonicQueue queue = new MonotonicQueue();
        for (int i : new int[]{1, 3, -1, 5, 3, 6, 7}) {
            queue.offer(i);
            System.out.println(queue);
        }
    }

}
