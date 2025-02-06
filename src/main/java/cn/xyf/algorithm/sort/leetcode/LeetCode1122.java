package cn.xyf.algorithm.sort.leetcode;

/**
 * @author Xuyifeng
 * @description 数组的相对排序
 * @date 2025/2/6 20:11
 */

public class LeetCode1122 {

    /*
        基于计数排序求解
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int i : arr1) {
            count[i]++;
        }
        int[] result = new int[arr1.length];
        int k = 0;
        for (int i : arr2) {
            while (count[i] > 0) {
                result[k++] = i;
                count[i]--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[k++] = i;
                count[i]--;
            }
        }
        return result;
    }

}
