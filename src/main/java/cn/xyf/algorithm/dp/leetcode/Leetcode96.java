package cn.xyf.algorithm.dp.leetcode;

/**
 * @author Xuyifeng
 * @description 不同的二叉搜索树 - 卡特兰数思想
 * @date 2025/2/12 13:52
 */

public class Leetcode96 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int j = 2; j < n + 1; j++) { // j 是求第 j 个卡特兰数
            for (int i = 0; i < j; i++) {
                dp[j] += dp[i] * dp[j - 1 - i];
            }
        }
        return dp[n];
    }

}
