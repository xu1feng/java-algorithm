package cn.xyf.algorithm.sort;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/6 13:24
 */

public class CountingSortNegative {
    /*
        要点：
        1. 让原始数组的最小值映射到 count[0] 最大值映射到 count 最右侧
        2. 原始数组元素 - 最小值 = count 索引
     */
    public static void sort(int[] a) {
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        int[] count = new int[max - min + 1];
        for (int i = 0; i < a.length; i++) {
            count[a[i] - min]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            // i + min 代表原始数组元素 count[i] 代表元素出现次数
            while (count[i] > 0) {
                a[k++] = i + min;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6, -1, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
