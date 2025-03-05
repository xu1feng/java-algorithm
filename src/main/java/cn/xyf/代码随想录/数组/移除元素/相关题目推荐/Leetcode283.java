package cn.xyf.代码随想录.数组.移除元素.相关题目推荐;

import cn.xyf.algorithm.string.Leetcode28;
import cn.xyf.代码随想录.数组.二分查找.相关题目推荐.Leetcode69;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/5 21:45
 */

public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Leetcode283().moveZeroes(new int[]{0, 1, 0, 3, 12});
        new Leetcode283().moveZeroes(new int[]{0});
    }
}
