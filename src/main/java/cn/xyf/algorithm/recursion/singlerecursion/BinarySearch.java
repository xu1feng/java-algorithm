package cn.xyf.algorithm.recursion.singlerecursion;

/**
 * @author: Xuyifeng
 * @date: 2025/1/18 16:14
 * @description: 递归二分查找
 */

public class BinarySearch {

    public static int search(int[] a, int target) {
        return f(a, target, 0, a.length - 1);
    }

    private static int f(int[] a, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int m = (left + right) >>> 1;
        if (target < a[m]) {
            return f(a, target, left, m - 1);
        } else if (a[m] < target) {
            return f(a, target, m + 1, right);
        } else {
            return m;
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 13, 21, 30, 44, 52, 53};
        int search = search(a, 13);
        System.out.println(search);
    }

}
