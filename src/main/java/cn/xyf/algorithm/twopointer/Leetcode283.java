package cn.xyf.algorithm.twopointer;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 22:38
 */

public class Leetcode283 {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
            }
            j++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Leetcode283().moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

}
