package cn.xyf.algorithm.dp.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Xuyifeng
 * @description 零钱兑换Ⅱ - 动态规划
 * @date 2025/2/11 16:33
 */

// 凑成总金额有几种凑法
public class Leetcode518 {

    /*
        面值   0       1       2       3       4       5   总金额-背包容量
         1    1       1       11      111     1111    11111

         2    1       1       11      111     1111    11111
                              2        12     211     2111
                                             22      221

         5    1      1       11      111     1111    11111
                             2        12     211     2111
                                             22      221
                                                     5

         if(放得下) {
            dp[i][j] = dp[i-1][j] + dp[i][j-coin.weight]
         } else(放不下) {
            dp[i][j] = dp[i-1][j]
         }
     */
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < amount + 1; j++) {
            if (j >= coins[0]) {
                dp[0][j] = dp[0][j - coins[0]];
            }
        }
        print(dp);
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            print(dp);
        }
        return dp[coins.length - 1][amount];
    }

    public static void main(String[] args) {
        Leetcode518 leetcode518 = new Leetcode518();
        int change = leetcode518.change(5, new int[]{1, 2, 5});
        System.out.println(change);
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

}
