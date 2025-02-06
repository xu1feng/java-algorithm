package cn.xyf.algorithm.sort;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 冒泡排序
 * @date 2025/2/4 13:37
 */

public class BubbleSort {

    private static void bubble(int[] a) {
        int right = a.length - 1;
        while (true) {
            int x = 0;
            for (int i = 0; i < right; i++) {
                if (a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    x = i;
                }
            }
            right = x;
            if (right == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        bubble(a);
        System.out.println(Arrays.toString(a));
    }

}
