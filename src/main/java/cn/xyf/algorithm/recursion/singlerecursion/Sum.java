package cn.xyf.algorithm.recursion.singlerecursion;

/**
 * @author: Xuyifeng
 * @date: 2025/1/19 13:47
 * @description: 递归求 n + n-1, ... , + 1 - 递归容易爆栈
 */

public class Sum {

    // f(n）= f(n-1) + n

    public static long sum(long n) {
        if (n == 1)
            return 1;
        return sum(n - 1) + n;
    }

    public static void main(String[] args) {
        long sum = sum(100);
        System.out.println(sum);
    }

}
