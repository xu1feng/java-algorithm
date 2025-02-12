package cn.xyf.algorithm.dp;

import java.util.Arrays;

import static cn.xyf.algorithm.dp.KnapsackProblem.print;

/**
 * @author Xuyifeng
 * @description 最长公共子串
 * @date 2025/2/12 10:59
 */

public class LCSubstring {

    /*
            i   t   h   e   i   m   a
        t   0   1   0   0   0   0   0
        h   0   0   2   0   0   0   0
        e   0   0   0   3   0   0   0
        m   0   0   0   0   0   1   0
        a   0   0   0   0   0   0   2

        if(相同字符) {
            dp[i][j] = dp[i-1][j-1] + 1
        } else(不相同字符) {
            dp[i][j] = 0
        }
     */

    private static int lcs(String a, String b) {
        int max = 0;
        int[][] dp = new int[b.length()][a.length()];
        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == b.charAt(i)) { // 找到相同字符
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1; // 找到前一行前一列的值 + 1
                    }
                    max = Integer.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }
            }
            print(dp, a, b);
        }
        return max;
    }

    static void print(int[][] dp, String a, String b) {
        System.out.println("-".repeat(23));
        Object[] array = a.chars().mapToObj(i -> String.valueOf((char) i)).toArray();
        System.out.printf("  "+"%2s ".repeat(a.length()) + "%n", array);
        for (int i = 0; i < b.length(); i++) {
            int[] d = dp[i];
            array = Arrays.stream(d).boxed().toArray();
            System.out.printf(b.charAt(i) + " " + "%2d ".repeat(d.length) + "%n", array);
        }
    }

    public static void main(String[] args) {
        System.out.println(lcs("itheima", "thema"));
    }

}
