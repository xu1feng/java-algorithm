package cn.xyf.algorithm.dp;

/**
 * @author Xuyifeng
 * @description 求斐波那契数列的第 n 项（动态规划）
 * @date 2025/2/10 17:24
 */

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci2(13));
    }

    /*
        要点1：
            从已知子问题的解，推导出当前问题的解
            推导过程可以表达为一个数学公式
        要点2：
            用一维或二维数组保存之前的计算结果（可以进一步优化）
     */
    private static int fibonacci(int n) {
        if (n <= 0) {
            return 0;       // 处理非法输入
        }
        int[] dp = new int[n + 1]; // 用来缓存结果
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 优化 - 降维
    private static int fibonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

}
