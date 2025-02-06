package cn.xyf.algorithm.sort;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 计数排序
 * @date 2025/2/6 12:59
 */

public class CountingSort {

    /*
        要点：
        1. 找到最大值，创建一个大小为 最大值 + 1 的 count 数组
        2. count 数组的索引对应原始数组的元素，用来统计该元素的出现次数
        3. 遍历 count 数组，根据 count 数组的索引（即原始数组的元素）以及出现次数，生成排序后内容
            count 数组的索引是：已排序好的

        前提：待排序元素 >= 0 且 最大值不能太大
     */
    public static void sort(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            // i 代表原始数组元素 count[i] 代表元素出现次数
            while (count[i] > 0) {
                a[k++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
