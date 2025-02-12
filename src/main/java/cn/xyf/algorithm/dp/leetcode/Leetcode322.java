package cn.xyf.algorithm.dp.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Xuyifeng
 * @description 零钱兑换 - 动态规划
 * @date 2025/2/11 14:50
 */

/*
    凑成总金额的凑法中，需要硬币最少个数是几？
 */
public class Leetcode322 {

    /*
        面值  0       1       2       3       4       5
         1   0       1       11      111     1111   11111
         2   0       1       2        12      22    122
         5   0       1       2        12      22     5

         面值  0       1       2       3       4       5
          10  0       max     max     max     max     max

         总金额 - 类比为背包容量
         硬币面值 - 类比为物品重量
         硬币个数 - 类比为物品价值，固定为1 （求价值最小的）

         if(装得下) {
            min(上次价值(个数)，剩余容量能装下的最小价值(个数) + 1)
            dp[i][j] = min(dp[i-1][j], dp[i][j-item.weight] + 1)
         } else {
            保留上次价值(个数)不变
            dp[i][j] = dp[i-1][j]
         }
     */
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int j = 1; j < amount + 1; j++) {
            if (j >= coins[0]) { // 装得下
                dp[0][j] = dp[0][j - coins[0]] + 1;
            } else {
                dp[0][j] = amount + 1; // 最大值
            }
        }
        // print(dp);
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]) { // 装得下
                    dp[i][j] = Integer.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // print(dp);
        return dp[coins.length - 1][amount] < amount + 1 ? dp[coins.length - 1][amount] : -1;
    }

    // 优化 - 降维
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 0 max max max max max
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j < amount + 1; j++) {
                // 装得下
                dp[j] = Integer.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] < amount + 1 ? dp[amount] : -1;
    }

    static void print(int[][] dp) {
        System.out.println("-".repeat(18));
        Object[] array = IntStream.range(0, dp[0].length + 1).boxed().toArray();
        System.out.printf(("%2d ".repeat(dp[0].length)) + "%n", array);
        for (int[] d : dp) {
            array = Arrays.stream(d).boxed().toArray();
            System.out.printf(("%2d ".repeat(d.length)) + "%n", array);
        }
    }

    public static void main(String[] args) {
        Leetcode322 leetcode322 = new Leetcode322();
        int count = leetcode322.coinChange2(new int[]{1, 2, 5}, 5);
        System.out.println(count);
    }

}
