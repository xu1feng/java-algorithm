package cn.xyf.algorithm.binarysearch;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

public class TestBinarySearch {

    @Test
    @DisplayName("binarySearch 基础版")
    public void test1() {
        int[] a = {7, 13, 21, 30, 44, 52, 53};
        int idx = BinarySearch.binarySearchBasic(a, 13);
        System.out.println(idx);
    }

    @Test
    public void test2() {
        int i = 0, j = Integer.MAX_VALUE - 1;

        int m = (i + j) / 2;
        System.out.println(m);

        i = m + 1;
//        m = (i + j) / 2;
        m = (i + j) >>> 1;
        System.out.println(m);
    }

    @Test
    @DisplayName("binarySearch 改动版")
    public void test3() {
        int[] a = {7, 13, 21, 30, 44, 52, 53};
        int idx = BinarySearch.binarySearchAlternative(a, 13);
        System.out.println(idx);
    }

    @Test
    @DisplayName("binarySearch Java 版")
    public void test4() {
        int[] a = {2, 5, 8};
        int target = 4;

        int i = Arrays.binarySearch(a, target);
        System.out.println(i);
        // -2 = - 插入点 - 1  ---> 插入点 = 1 即往这个升序数组中插入的位置为1

        if (i < 0) {
            int insertIndex = Math.abs(i + 1); // 插入点索引
            int[] b = new int[a.length + 1];
            System.arraycopy(a, 0, b, 0, insertIndex);
            b[insertIndex] = target;
            System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
            System.out.println(Arrays.toString(b));
        }
    }

    @Test
    @DisplayName("binarySearch LeftMost")
    public void test5() {
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        int idx = BinarySearch.binarySearchLeftMost(a, 4);
        System.out.println(idx);
    }

    @Test
    @DisplayName("binarySearch RightMost")
    public void test6() {
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        int idx = BinarySearch.binarySearchRightMost(a, 4);
        System.out.println(idx);
    }

}
