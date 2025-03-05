package cn.xyf.代码随想录.数组.二分查找.相关题目推荐;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/3 20:58
 */

public class Leetcode35 {

    // 解法一：二分查找，左闭右闭
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        // 如果没有找到，left或者right+1刚好指向target会被按顺序插入的位置
        return left; // 也可以返回 right + 1
    }

    // 解法二：二分查找，左闭右开
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = (left + right) >>> 1;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                return middle;
            }
        }
        // 如果没有找到，left或者right刚好指向target会被按顺序插入的位置
        return left; // 也可以返回 right
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode35().searchInsert2(new int[]{1, 3, 5, 6}, 5));
    }
}
