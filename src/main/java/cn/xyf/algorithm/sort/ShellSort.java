package cn.xyf.algorithm.sort;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 希尔排序
 * @date 2025/2/4 14:30
 */

public class ShellSort {

    public static void sort(int[] a) {
        // a.length / 2   每次 /2  直到 1
        for (int gap = a.length >> 1; gap >= 1; gap = gap >> 1) {
            for (int low = gap; low < a.length; low++) {
                int t = a[low];
                int i = low - gap;
                // 自右向左找插入位置，如果比插入元素大，则不断右移，空出插入位置
                while (i >= 0 && t < a[i]) {
                    a[i + gap] = a[i];
                    i = i - gap;
                }
                // 找到插入位置
                if (i != low - gap) {
                    a[i + gap] = t;
                }
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
