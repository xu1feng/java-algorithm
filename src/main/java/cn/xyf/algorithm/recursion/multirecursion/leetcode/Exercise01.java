package cn.xyf.algorithm.recursion.multirecursion.leetcode;

import java.util.Arrays;

/**
 * @author: Xuyifeng
 * @date: 2025/1/19 15:39
 * @description: 爬楼梯 - LeetCode70
 */

public class Exercise01 {

    public int climbStairs(int n) {
        // n = 1 为特殊情况
        if (1 == n)
            return 1;
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[1] = 1;
        cache[2] = 2;
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
