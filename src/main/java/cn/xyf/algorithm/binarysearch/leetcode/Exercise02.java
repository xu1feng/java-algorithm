package cn.xyf.algorithm.binarysearch.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/16 21:13
 * @description: 搜索插入位置 - Leetcode 35
 */

public class Exercise02 {

    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (nums[mid] < target) i = mid + 1;
            else if (target < nums[mid]) j = mid - 1;
            else return mid;
        }
        return i;
    }

}
