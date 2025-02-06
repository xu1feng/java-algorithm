package cn.xyf.algorithm.sort;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 选择排序
 * @date 2025/2/4 13:49
 */

public class SelectionSort {

    private static void selection(int[] a) {
        // 1. 选择轮数 a.length - 1
        // 2. 交换的索引位置 初始值 a.length - 1，每次再递减
        for (int right = a.length - 1; right > 0 ; right--) {
            int max = right;
            for (int i = 0; i < right; i++) {
                if (a[i] > a[max]) {
                    max = i;
                }
            }
            if (max != right) {
                swap(a, right, max);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        selection(a);
        System.out.println(Arrays.toString(a));
    }

}
