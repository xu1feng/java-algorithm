package cn.xyf.algorithm.divideandconquer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Xuyifeng
 * @description 快速选择算法 - 分而治之
 * @date 2025/2/14 14:20
 */

public class QuickSelect {

    /*
        求排在第 i 名的元素，i 从 0 开始，由小到大排
        6   5   1   2   4
     */

    static int quick(int[] array, int left, int right, int i) {
        int p = partition(array, left, right); // 基准点元素的索引值
        if (p == i) {
            return array[p];
        }
        if (i < p) { // 到左边找
            return quick(array, left, p - 1, i);
        } else {
            return quick(array, p + 1, right, i);
        }
    }

    private static int partition(int[] a, int left, int right) {
        // 随机元素作为基准点
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        // [0, 9], right - left + 1 = 3, [0, 2] + 4 = [4, 6]
        swap(a, idx, left);
        int pv = a[left]; // 基准点元素的值
        int i = left;
        int j = right;
        while (i < j) {
            // 1. j 从右向左找小（等）的
            while (i < j && a[j] > pv) {
                j--;
            }
            // 2. i 从左向右找大的
            while (i < j && a[i] <= pv) {
                i++;
            }
            // 3. 交换位置
            swap(a, i, j);
        }
        swap(a, i, left);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] array = new int[] {6, 5, 1, 2, 4};
        System.out.println(quick(array, 0, array.length - 1, 0));
    }

}
