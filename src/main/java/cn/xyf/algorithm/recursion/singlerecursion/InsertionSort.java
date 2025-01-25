package cn.xyf.algorithm.recursion.singlerecursion;

import java.util.Arrays;

/**
 * @author: Xuyifeng
 * @date: 2025/1/19 9:38
 * @description: 递归插入排序
 */

public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {4, 5, 3, 1, 2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
//        insertion(a, 1);
        insertion2(a, 1);
    }

    /**
     * 递归函数 将 left 位置的元素插入至 [0 .. left-1] 的已排序区域
     *
     * @param a    待排序数组
     * @param left 未排序区域的左边界
     */
    private static void insertion(int[] a, int left) {
        if (left == a.length) {
            return;
        }

        int temp = a[left];
        int i = left - 1; // 已排序区域右边界

        while (i >= 0 && a[i] > temp) { // 没有找到插入位置
            a[i + 1] = a[i]; // 空出插入位置
            i--;
        }

        // 找到插入位置
        if (i + 1 != left)
            a[i + 1] = temp;

        insertion(a, left + 1);
    }

    private static void insertion2(int[] a, int left) {
        if (left == a.length)
            return;

        int i = left - 1;
        while (i >= 0 && a[i] > a[i + 1]) {
            int temp = a[i];
            a[i] = a[i + 1];
            a[i + 1] = temp;
            i--;
        }

        insertion2(a, left + 1);
    }

}
