package cn.xyf.代码随想录.数组.移除元素.相关题目推荐;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/6 21:06
 */

public class Leetcode977 {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] res = new int[nums.length];
        int idx = nums.length - 1;
        while (i <= j) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                res[idx--] = nums[i] * nums[i];
                i++;
            } else {
                res[idx--] = nums[j] * nums[j];
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Leetcode977().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
