package cn.xyf.代码随想录.字符串.反转字符串;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/19 21:41
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
    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

}
