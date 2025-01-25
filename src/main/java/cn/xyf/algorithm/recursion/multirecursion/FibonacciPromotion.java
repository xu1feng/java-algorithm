package cn.xyf.algorithm.recursion.multirecursion;

import java.util.Arrays;

/**
 * @author: Xuyifeng
 * @date: 2025/1/19 13:32
 * @description: 递归优化求斐波那契第n项 - 记忆法
 */

public class FibonacciPromotion {

    public static void main(String[] args) {
        int fibonacci = fibonacci(5);
        System.out.println(fibonacci);
    }

    /**
     * 使用 Memorization（记忆法，也称备忘录）改进
     *
     * @param n 第 n 项
     * @return 第 n 项的值
     */
    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1); // [-1, -1, -1, -1, -1, -1]
        cache[0] = 0;
        cache[1] = 1;
        return f(n, cache);
    }

    public static int f(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }

        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x + y;
        return cache[n];
    }

}
