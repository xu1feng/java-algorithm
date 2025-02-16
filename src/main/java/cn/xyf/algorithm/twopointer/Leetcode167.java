package cn.xyf.algorithm.twopointer;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 21:20
 */

public class Leetcode167 {

    /*
        思路
        - 两个指针 i 和 j 分别指向最左侧和最右侧的数字
        - 它俩指向的数字和 target 相比
            - 小于 target i++ 向右找
            - 大于 target j-- 向左找
            - 等于 target 找到
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                break;
            }
        }
        return new int[]{i + 1, j + 1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Leetcode167().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

}
