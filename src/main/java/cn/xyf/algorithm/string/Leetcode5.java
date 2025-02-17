package cn.xyf.algorithm.string;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/16 16:37
 */

public class Leetcode5 {

    public String longestPalindrome(String s) {
        left = 0;
        right = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            extend(chars, i, i); // 一个字符作为中心点
            extend(chars, i, i + 1); // 两个字符作为中心点
        }
        return new String(chars, left, right - left + 1);
    }

    static int left; // i
    static int right; // j

    static void extend(char[] chars, int i, int j) {
        while (i >= 0 && j < chars.length && chars[i] == chars[j]) { // 如果是回文就扩大回文范围
            i--;
            j++;
        }
        // 不是回文
        i++;
        j--;
        if (j - i > right - left) {
            left = i;
            right = j;
        }
    }

    public static void main(String[] args) {
        extend("babad".toCharArray(), 2, 2);
        System.out.println(left);
        System.out.println(right);
    }

}
