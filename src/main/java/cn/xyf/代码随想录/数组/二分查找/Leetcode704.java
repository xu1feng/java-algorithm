package cn.xyf.代码随想录.数组.二分查找;

import cn.xyf.algorithm.twopointer.Leetcode344;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/3 20:34
 */

public class Leetcode704 {
    // 版本一：[left, right]
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    // 版本二：[left, right)
    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = (left + right) >>> 1;
            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode704 leetcode704 = new Leetcode704();
        System.out.println(leetcode704.search2(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}
