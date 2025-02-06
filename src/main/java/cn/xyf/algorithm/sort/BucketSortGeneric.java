package cn.xyf.algorithm.sort;

import cn.xyf.datastruct.array.DynamicArray;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/6 13:53
 */

public class BucketSortGeneric {

    /*
        0 0,1,2
        1 3,4,5
        2 6,7,8
        3 9,10,11
     */
    public static void sort(int[] ages, int range) {
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

    public static void main(String[] args) {
        int[] ages = {9, 4, 6, 8, 1, 3, 2, 5, 7};
        System.out.println(Arrays.toString(ages));
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
        DynamicArray[] buckets = new DynamicArray[(max - min) / 3 + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new DynamicArray();
        }
        // 2. 放入年龄数据
        for (int age : ages) {
            buckets[(age - min) / 3].addLast(age);
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
        System.out.println(Arrays.toString(ages));
    }

}
