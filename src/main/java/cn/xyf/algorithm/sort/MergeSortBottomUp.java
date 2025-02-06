package cn.xyf.algorithm.sort;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 归并排序 - 非递归 自下而上
 * @date 2025/2/4 15:22
 */

public class MergeSortBottomUp {

    /**
     *
     * @param a1 原始数组
     * @param i 第一个有序范围
     * @param iEnd 第一个有序范围
     * @param j 第二个有序范围
     * @param jEnd 第二个有序范围
     * @param a2 临时数组
     */
    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2) {
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            if (a1[i] < a1[j]) {
                a2[k] = a1[i];
                i++;
            } else {
                a2[k] = a1[j];
                j++;
            }
            k++;
        }
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
        }
    }

    public static void sort(int[] a) {
        int n = a.length;
        int[] temp = new int[a.length];
        // width 代表有序区间的宽度，取值依次为 1、2、4...
        for (int width = 1; width < n; width *= 2) {
            // [left, right] 分别代表待合并区间的左右边界
            for (int left = 0; left < n; left += 2 * width) {
                int right = Math.min(n - 1, left + 2 * width - 1);
                int m = Math.min(n - 1, left + width - 1);
                merge(a, left, m, m + 1, right, temp);
            }
            System.arraycopy(temp, 0, a, 0, n);
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
