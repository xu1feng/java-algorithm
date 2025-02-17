package cn.xyf.algorithm.string;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/16 14:47
 */

public class KMP {

    static int strStr(String str1, String str2) {
        char[] origin = str1.toCharArray(); // 原始
        char[] pattern = str2.toCharArray(); // 模式
        int[] lsp = lps(pattern); // 最长前后缀数组

        /*
            1. 匹配成功，i++，j++，直到 j == 模式字符串长度
            2. 匹配失败
                j != 0 跳过最长前后缀字符，继续匹配
                j == 0 则 i++
         */
        int i = 0;
        int j = 0;
        while (pattern.length - j <= origin.length - i) {
            if (origin[i] == pattern[j]) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = lsp[j - 1];
            }
            if (j == pattern.length) {
                // 找到解
                return i - j;
            }
        }
        return -1;
    }

    /*
        最长前后缀数组：只跟模式字符串相关
        1. 索引：使用了模式字符串前 j 个字符串 - 1
        2. 值：最长前后缀的长度（恰好是失败时j要跳转的位置）
     */
    static int[] lps(char[] pattern) {
        /*
            遇到相同字符：
                记录共同前后缀长度
                长度即为 j+1
                长度记录至数组 i 索引处
                然后 i++，j++
            遇到不同字符：
                前面没有共同部分(j=0)
                前面有共同部分，j向回找
                    无需对比的地方，可以跳过
                    无需对比的字符个数，之前已计算过
         */
        int[] lps = new int[pattern.length];
        int i = 1;
        int j = 0;
        while (i < pattern.length) {
            if (pattern[i] == pattern[j]) {
                lps[i] = j + 1;
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = lps[j - 1];
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        System.out.println(strStr("ababababcabacacababaca", "ababaca"));
//        System.out.println("ababababcabacacababaca".indexOf("ababaca"));
//        System.out.println(Arrays.toString(lps("ababaca".toCharArray())));
    }

}
