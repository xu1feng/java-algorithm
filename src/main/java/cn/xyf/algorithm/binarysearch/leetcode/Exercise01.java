package cn.xyf.algorithm.binarysearch.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/16 20:49
 * @description: 二分查找 - LeetCode 704
 */

public class Exercise01 {

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (nums[mid] < target) i = mid + 1;
            else if (target < nums[mid]) j = mid - 1;
            else return mid;
        }
        return -1;
    }

}
