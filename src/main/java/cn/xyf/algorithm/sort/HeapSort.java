package cn.xyf.algorithm.sort;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 堆排序
 * @date 2025/2/4 14:01
 */

public class HeapSort {

    public static void sort(int[] a) {
        buildHeap(a, a.length);
        for (int right = a.length - 1; right > 0; right--) {
            swap(a, 0, right);
            down(a, 0, right);
        }
    }

    // 建堆
    private static void buildHeap(int[] a, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(a, i, size);
        }
    }

    // 下潜
    private static void down(int[] a, int parent, int size) {
        while (true) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int max = parent;
            if (left < size && a[left] > a[max]) {
                max = left;
            }
            if (right < size && a[right] > a[max]) {
                max = right;
            }
            if (max == parent) { // 没找到更大的孩子
                break;
            }
            // 找到了更大的孩子
            swap(a, max, parent);
            parent = max;
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
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
