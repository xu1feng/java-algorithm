package cn.xyf.algorithm.binarysearch;

/**
 * @author: Xuyifeng
 * @date: 2025/1/15 17:21
 * @description: 线性查找
 */

public class LinearSearch {

    /**
     * 线性查找
     *
     * @param a 待查找的数组（可以不是升序的）
     * @param target 待查找的目标
     * @return 找到则返回 索引下标
     *         找不到则返回 -1
     */
    public static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 1. 最差的执行情况
    // 2. 假设每行语句行时间一样
    /**
     * 数组元素个数 n
     * int i = 0;       1
     * i < a.length;    n + 1
     * i++;             n
     * a[i] == target   n
     * return -1;       1
     *                  3*n + 3
     */

}
