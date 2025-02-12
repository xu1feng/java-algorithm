package cn.xyf.algorithm.dp.leetcode;

/**
 * @author Xuyifeng
 * @description 两个字符串的删除操作
 * @date 2025/2/12 13:10
 */

public class Leetcode538 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            char x = chars1[i - 1];
            for (int j = 1; j < n + 1; j++) {
                char y = chars2[j - 1];
                if (x == y) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }

    public static void main(String[] args) {
        Leetcode538 leetcode538 = new Leetcode538();
        System.out.println(leetcode538.minDistance("leetcode", "etco")); // 8-4 + 4-4 = 4
    }

}
