package cn.xyf.algorithm.dp.leetcode;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/12 15:02
 */

public class Leetcode198 {

    /*
        价值  0   1   2   3   4
             0   0   0   0   0
        0(2) 2   0   0   0   0
        1(7) 2   7   0   0   0
        2(9) 2   7   11  0   0
        3(3) 2   7   11  11  0
        4(1) 2   7   11  11  12

        dp[4] = dp[2] + 1 = 12
        dp[3] = max(dp[2], dp[1]+3) = 11

        dp[i] = max(dp[i-1], dp[i-2]+value)
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Leetcode198 leetcode198 = new Leetcode198();
        System.out.println(leetcode198.rob(new int[]{1, 2, 3, 1}));
        System.out.println(leetcode198.rob(new int[]{2, 7, 9, 3, 1}));
    }

}
