package cn.xyf.algorithm.hashtable.leetcode;

import java.util.HashSet;

/**
 * @author Xuyifeng
 * @description 只出现一次的数字
 * @date 2025/2/2 14:23
 */

public class LeetCode136 {

    /*
        思路2：
        1. 任何相同的数字异或，都是 0
        2. 任何数字与 0 异或，结果是数字本身
     */
    public int singleNumber2(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }

    /*
        思路：
        1. 准备一个 set 集合，逐一放入数组元素
        2. 遇到重复的，则删除
        3. 最后留下来的，就是那个没有重复的数字
     */
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.toArray(new Integer[0])[0];
    }

}
