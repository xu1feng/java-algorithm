package cn.xyf.datastruct.priorityqueue;

import org.junit.Test;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/1/23 10:46
 */

public class TestPriorityQueue1 {

    @Test
    public void poll() {
        PriorityQueue1<Entry> queue = new PriorityQueue1<>(5);
        queue.offer(new Entry("task1", 4));
        queue.offer(new Entry("task2", 3));
        queue.offer(new Entry("task3", 2));
        queue.offer(new Entry("task4", 5));
        queue.offer(new Entry("task5", 1));
        System.out.println(queue.offer(new Entry("task6", 6)));

        System.out.println(queue.poll());
    }

}
