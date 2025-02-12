package cn.xyf.algorithm.dp;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 卡特兰数
 * @date 2025/2/12 14:01
 */

public class Catalan {

    static int catalan(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int j = 2; j < n + 1; j++) { // j 是求第 j 个卡特兰数
            for (int i = 0; i < j; i++) {
//                System.out.printf("(%d,%d)\t", i, j - 1 - i);
                dp[j] += dp[i] * dp[j - 1 - i];
            }
//            System.out.println();
//            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(catalan(6));
    }

}
