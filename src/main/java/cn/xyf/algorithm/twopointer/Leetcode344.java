package cn.xyf.algorithm.twopointer;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 22:52
 */

public class Leetcode344 {

    public void reverseString(char[] s) {
        int n = s.length / 2;
        int i = 0;
        int j = s.length - 1;
        while (i < n) {
            swap(s, i, j);
            i++;
            j--;
        }
        System.out.println(Arrays.toString(s));
    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        new Leetcode344().reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

}
