package cn.xyf.algorithm.dp.leetcode;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/11 10:32
 */

public class Leetcode62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; // 记录每个坐标的路径总数
        // 第一列的路径总数初始化为1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 第一行的路径总数初始化为1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 其余坐标的路径总数 = 上方坐标路径总数 + 左边左边路径总数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 优化 - 降维
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        // 第一行全部初始化为1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            // 最左边的列每次初始化为1
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1]; // 路径总数 = 上次路径总数 + 左边的路径总数
            }
        }
        return dp[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Leetcode62().uniquePaths2(3, 7));
    }

}
