package cn.xyf.algorithm.dp.leetcode;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 最长递增子序列
 * @date 2025/2/12 13:21
 */

public class Leetcode300 {

    /*
        1   3   6   4   9
        1   13  16  14  19
                136 134 139
                        1369
                        169
                        149
                        39
                        69
                        49
     */
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // 满足升序条件的数字
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
                max = Integer.max(max, dp[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        Leetcode300 code = new Leetcode300();
        System.out.println(code.lengthOfLIS(new int[]{1, 3, 6, 4, 9}));
//        System.out.println(code.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(code.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        //                                            1 3 6 7 9 10  = 6
        //                                            1 3 4 5 6     = 5
//        System.out.println(code.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
//        System.out.println(code.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

}
