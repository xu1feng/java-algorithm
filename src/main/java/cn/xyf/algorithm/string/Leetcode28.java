package cn.xyf.algorithm.string;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/16 14:34
 */

public class Leetcode28 {

    public int strStr(String haystack, String needle) {
        char[] origin = haystack.toCharArray(); // 原始
        char[] pattern = needle.toCharArray(); // 模式
        int i = 0, j = 0;
        while (i <= origin.length - pattern.length) {
            for (j = 0; j < pattern.length; j++) {
                if (origin[i + j] != pattern[j]) {
                    break;
                }
            }
            if (j == pattern.length) {
                return i;
            }
            i++;
        }
        return -1;
    }

}
