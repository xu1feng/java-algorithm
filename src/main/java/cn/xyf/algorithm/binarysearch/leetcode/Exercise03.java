package cn.xyf.algorithm.binarysearch.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Xuyifeng
 * @date: 2025/1/16 21:26
 * @description: 搜索开始结束位置 - Leetcode 34
 */

public class Exercise03 {

    public int[] searchRange(int[] nums, int target) {
        int left = leftMost(nums, target);
        int right = rightMost(nums, target);
        return new int[]{left, right};
    }

    public int leftMost(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (a[mid] > target)
                j = mid - 1;
            else if (target > a[mid])
                i = mid + 1;
            else {
                // 记录候选位置
                candidate = mid;
                j = mid - 1;
            }
        }
        return candidate;
    }

    public int rightMost(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (a[mid] > target)
                j = mid - 1;
            else if (target > a[mid])
                i = mid + 1;
            else {
                // 记录候选位置
                candidate = mid;
                i = mid + 1;
            }
        }
        return candidate;
    }

}
