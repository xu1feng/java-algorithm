package cn.xyf.pat.yi;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/12 15:21
 */

public class Test19 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        long l = start - end;
        System.out.println(l);
    }
}
