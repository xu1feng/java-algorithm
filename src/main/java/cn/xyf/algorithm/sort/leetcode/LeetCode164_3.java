package cn.xyf.algorithm.sort.leetcode;

import cn.xyf.algorithm.sort.InsertionSort;
import cn.xyf.datastruct.array.DynamicArray;

/**
 * @author Xuyifeng
 * @description 最大间距
 * @date 2025/2/6 20:50
 */

public class LeetCode164_3 {

    public int maximumGap(int[] nums) {
        // 1. 处理特殊情况
        if (nums.length < 2) {
            return 0;
        }
        // 2. 桶排序
        int max = nums[0];
        int min = nums[0];
        for (int i1 = 1; i1 < nums.length; i1++) {
            if (nums[i1] > max) {
                max = nums[i1];
            }
            if (nums[i1] < min) {
                min = nums[i1];
            }
        }
        // 2.1. 准备桶
        /*
            计算桶个数               期望桶个数
            (max - min) / range + 1 = nums.length
            range = (max - min) / (nums.length - 1)
         */
        int range = Math.max(max - min / (nums.length - 1), 1);
        DynamicArray[] buckets = new DynamicArray[(max - min) / range + 1];
        for (int i1 = 0; i1 < buckets.length; i1++) {
            buckets[i1] = new DynamicArray();
        }
        // 2.2. 放入年龄数据
        for (int age : nums) {
            buckets[(age - min) / range].addLast(age);
        }
        // 2.3. 桶内元素排序
        int k = 0;
        for (DynamicArray bucket : buckets) {
            int[] array = bucket.array();
            InsertionSort.sort(array);
            // 4. 把每个桶排序好的内容，依次放入原始数组
            for (int i1 : array) {
                nums[k++] = i1;
            }
        }
        // 3. 寻找最大差值
        int r = 0;
        for (int i = 1; i < nums.length; i++) {
            r = Math.max(r, nums[i] - nums[i - 1]);
        }
        return r;
    }

}
