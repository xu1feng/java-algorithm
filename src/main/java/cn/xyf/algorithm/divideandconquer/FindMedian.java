package cn.xyf.algorithm.divideandconquer;

/**
 * @author Xuyifeng
 * @description 数组中的中位数 - 快速选择
 * @date 2025/2/14 14:39
 */

public class FindMedian {

    /*
        偶数个
            3   1   5   4
        奇数个
            4   5   1
            4   5   1   6   3
     */

    public static double findMedian(int[] nums) {
        if (nums.length % 2 == 1) { // 奇数
            return QuickSelect.quick(nums, 0, nums.length - 1, nums.length / 2);
        } else { // 偶数
            int x = QuickSelect.quick(nums, 0, nums.length - 1, nums.length / 2);
            int y = QuickSelect.quick(nums, 0, nums.length - 1, nums.length / 2 - 1);
            return (x + y) / 2.0;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedian(new int[]{3, 1, 5, 4}));
        System.out.println(findMedian(new int[]{3, 1, 5, 4, 7, 8}));
        System.out.println(findMedian(new int[]{4, 5, 1}));
        System.out.println(findMedian(new int[]{4, 5, 1, 6, 3}));
    }

}
