package cn.xyf.代码随想录.数组.二分查找.相关题目推荐;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/3 21:14
 */

public class Leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int left = leftTarget(nums, target);
        int right = rightTarget(nums, target);
        return new int[]{left, right};
    }

    private int rightTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int candidate = -1;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                candidate = middle;
                left = middle + 1; // 继续向右
            }
        }
        return candidate;
    }

    private int leftTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int candidate = -1;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                candidate = middle;
                right = middle - 1; // 继续向左
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Leetcode34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
