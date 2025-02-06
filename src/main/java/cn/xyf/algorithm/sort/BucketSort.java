package cn.xyf.algorithm.sort;

import cn.xyf.datastruct.array.DynamicArray;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/6 13:38
 */

public class BucketSort {

    public static void sort(int[] ages) {
        // 1. 准备桶
        DynamicArray[] buckets = new DynamicArray[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new DynamicArray();
        }
        // 2. 放入年龄数据
        for (int age : ages) {
            buckets[age / 10].addLast(age);
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

    public static void main(String[] args) {
        int[] ages = {20, 18, 28, 66, 25, 31, 67, 30, 6};
        System.out.println(Arrays.toString(ages));
        sort(ages);
        System.out.println(Arrays.toString(ages));
    }

}
