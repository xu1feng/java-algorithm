package cn.xyf.algorithm.dp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/12 14:33
 */

public class Leetcode22 {

    public List<String> generateParenthesis(int n) {
        ArrayList<String>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>(List.of("")); // ""
        dp[1] = new ArrayList<>(List.of("()")); // ()
        // dp[2] = ()(), (())
        for (int j = 2; j < n + 1; j++) { // j 是求第 j 个卡特兰数
            dp[j] = new ArrayList<>();
            for (int i = 0; i < j; i++) {
                for (String k1 : dp[i]) {
                    for (String k2 : dp[j - 1 - i]) {
                        dp[j].add("(" + k1 + ")" + k2);
                    }
                }
            }
        }
        return dp[n];
    }

}
