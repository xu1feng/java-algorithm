package cn.xyf.algorithm.recursion.singlerecursion;

import java.util.Arrays;

/**
 * @author: Xuyifeng
 * @date: 2025/1/18 16:24
 * @description: 递归冒泡排序
 */

public class BubbleSort {

    public static void sort(int[] a) {
        bubble(a, a.length - 1);
    }

    /**
     * 递归函数 在范围[0 .. j]内冒泡最大元素到右侧
     *
     * @param a 待排序数组
     * @param right 未排序区域的右边界
     */
    public static void bubble(int[] a, int right) {
        if (right == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < right; i++) {
            if (a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                x = i;
            }
        }
        bubble(a, x);
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
