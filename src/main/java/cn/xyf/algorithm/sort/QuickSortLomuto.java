package cn.xyf.algorithm.sort;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/6 11:32
 */

import java.util.Arrays;

/**
 *  <h3>单边循环快排（lomuto 洛穆托分区方案）</h3>
 *  核心思想：每轮找到一个基准点元素，把比它小的放到左边，比它大的放到它右边，这成为分区
 *  <ol>
 *      <li>选择最右元素作为基准点元素</li>
 *      <li>j 指针负责找到比基准点小的元素，一旦找到则与 i 进行交换</li>
 *      <li>i 指针指向大于基准点元素的左边界，也是每次交换的目标索引</li>
 *      <li>最后基准点与 i 交换，i 即为分区位置</li>
 *  </ol>
 */

public class QuickSortLomuto {

    public static void sort(int[] a) {
        quick(a, 0, a.length - 1);
    }

    private static void quick(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(a, left, right); // p 代表基准点元素索引
        quick(a, left, p - 1);
        quick(a, p + 1, right);
    }

    private static int partition(int[] a, int left, int right) {
        int pv = a[right]; // 基准点元素的值
        int i = left;
        int j = left;
        while (j < right) {
            if (a[j] < pv) { // j 找到比基准点小的了，i 没找到比基准点大的
                if (i != j) {
                    swap(a, i, j);
                }
                i++;
            }
            j++;
        }
        swap(a, i, right);
        return i;
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
