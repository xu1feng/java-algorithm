package cn.xyf.algorithm.sort.leetcode;

import cn.xyf.algorithm.sort.InsertionSort;
import cn.xyf.datastruct.array.DynamicArray;

/**
 * @author Xuyifeng
 * @description 最大间距
 * @date 2025/2/6 20:50
 */

public class LeetCode164_1 {

    private static void sort(int[] ages, int range) {
        int max = ages[0];
        int min = ages[0];
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] > max) {
                max = ages[i];
            }
            if (ages[i] < min) {
                min = ages[i];
            }
        }
        // 1. 准备桶
        DynamicArray[] buckets = new DynamicArray[(max - min) / range + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new DynamicArray();
        }
        // 2. 放入年龄数据
        for (int age : ages) {
            buckets[(age - min) / range].addLast(age);
        }
        // 3. 桶内元素排序
        int k = 0;
        for (DynamicArray bucket : buckets) {
            int[] array = bucket.array();
            InsertionSort.sort(array);
            // 4. 把每个桶排序好的内容，依次放入原始数组
            for (int i : array) {
                ages[k++] = i;
            }
        }
    }

    public int maximumGap(int[] nums) {
        // 1. 处理特殊情况
        if (nums.length < 2) {
            return 0;
        }
        // 2. 桶排序
        sort(nums, 1);
        // 3. 寻找最大差值
        int r = 0;
        for (int i = 1; i < nums.length; i++) {
            r = Math.max(r, nums[i] - nums[i - 1]);
        }
        return r;
    }

}
