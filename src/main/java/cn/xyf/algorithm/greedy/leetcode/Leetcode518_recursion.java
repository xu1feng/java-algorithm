package cn.xyf.algorithm.greedy.leetcode;

/**
 * @author Xuyifeng
 * @description 零钱兑换Ⅱ - 凑成总金额有几种凑法
 * @date 2025/2/10 12:46
 */

public class Leetcode518_recursion {

    public int change(int amount, int[] coins) {
        return rec(0, coins, amount);
    }

    /**
     * 求凑成剩余金额的解的个数
     * @param index 当前硬币索引
     * @param coins 硬币面值数组
     * @param remainder 剩余金额
     * @return 解的个数
     */
    private int rec(int index, int[] coins, int remainder) {
        // 情况1：剩余金额 < 0 - 无解
        // 情况2：剩余金额 > 0 - 继续递归
        // 情况3：剩余金额 = 0 - 有解
        if (remainder < 0) {
            return 0;
        } else if (remainder > 0) {
            int count = 0;
            for (int i = index; i < coins.length; i++) {
                count += rec(i, coins, remainder - coins[i]);
            }
            return count;
        } else {
            return 1;
        }
    }

}
