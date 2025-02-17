package cn.xyf.algorithm.string;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/16 16:23
 */

public class Leetcode14 {

    public String longestCommonPrefix(String[] strs) {
        /*
            情况1：比较某一列时，遇到不同字符，i 之前的字符就是解
            情况2：比较某一列时，遇到字符串长度不够，i 之前的字符就是解
            情况3：i 循环自然结束，此时第一个字符串就是解
         */
        char[] first = strs[0].toCharArray(); // 第一个字符串
        for (int i = 0; i < first.length; i++) {
            char ch = first[i];
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || ch != strs[j].charAt(i)) { // 情况2 || 情况1
                    return new String(first, 0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {

    }

}
