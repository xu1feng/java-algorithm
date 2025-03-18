package cn.xyf.代码随想录.数组.长度最小的子数组.相关题目推荐;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/7 21:45
 */

public class Leetcode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int ans = 0;
        int prod = 1; // 乘积
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            // l r
            // [l,r] < k -> [l+1,r] < k .... [r,r] < k
            // r - l + 1
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode713().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
