package cn.xyf.datastruct.blockingqueue;

import org.junit.Test;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/1/23 16:31
 */

public class TestBlockingQueue1 {

    @Test
    public void offer() throws InterruptedException{
        BlockingQueue1<String> queue = new BlockingQueue1<>(3);

        Thread t1 = new Thread(() -> {
           try {
               System.out.println(System.currentTimeMillis() + " - begin");
               queue.offer("任务1");
               System.out.println(queue);
               queue.offer("任务2");
               System.out.println(queue);
               queue.offer("任务3");
               System.out.println(queue);
               queue.offer("任务4", 5000);
               System.out.println(queue);
               System.out.println(System.currentTimeMillis() + " - end");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }, "生产者");
        t1.start();

        Thread.sleep(2000);
        queue.poll();
    }

}
