package cn.xyf.algorithm.dp.leetcode;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 最长公共子序列
 * @date 2025/2/12 11:19
 */

public class Leetcode1143 {

    /*
                a   b   c   x   y   z
             0  0   0   0   0   0   0
          a  0  1   1   1   1   1   1
          b  0  1   2   2   2   2   2
          x  0  1   2   2   3   3   3
          y  0  1   2   2   3   4   4
          z  0  1   2   2   3   4   5

          if(相同字符) {
             找到上一行上一列坐标的值 + 1
          } else(不相同字符) {
             max(上一行, 上一列)
          }
     */

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        print(dp, text2, text1);
        return dp[m][n];
    }

    static void print(int[][] dp, String a, String b) {
        System.out.println("-".repeat(23));
        Object[] array = a.chars().mapToObj(i -> String.valueOf((char) i)).toArray();
        System.out.printf("     " + "%2s ".repeat(a.length()) + "%n", array);
        for (int i = 0; i < b.length(); i++) {
            int[] d = dp[i + 1];
            array = Arrays.stream(d).boxed().toArray();
            System.out.printf(b.charAt(i) + " " + "%2d ".repeat(d.length) + "%n", array);
        }
    }

    public static void main(String[] args) {
        Leetcode1143 code = new Leetcode1143();
        System.out.println(code.longestCommonSubsequence("abxyz", "abcxyz"));
    }

}
