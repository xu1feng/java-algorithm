package cn.xyf.algorithm.greedy.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Xuyifeng
 * @description 零钱兑换 - 凑成总金额的凑法中，需要硬币最少个数是几
 * @date 2025/2/10 12:48
 */

public class Leetcode322_recursion {

    static int min = -1; // 需要的最少硬币数
    public int coinChange(int[] coins, int amount) {
        rec(0, coins, amount, new AtomicInteger(-1));
        return min;
    }

    /**
     *
     * @param index 当前硬币索引
     * @param coins 硬币面值数组
     * @param remainder 剩余金额
     * @param count 代表某一组合 钱币总数
     */
    private void rec(int index, int[] coins, int remainder, AtomicInteger count) {
        count.incrementAndGet(); // count++
        if (remainder == 0) {
            if (min == -1) {
                min = count.get();
            } else {
                min = Integer.min(min, count.get());
            }
        } else if (remainder > 0) {
            for (int i = index; i < coins.length; i++) {
                rec(i, coins, remainder - coins[i], count);
            }
        }
        count.decrementAndGet(); // count--
    }

}
