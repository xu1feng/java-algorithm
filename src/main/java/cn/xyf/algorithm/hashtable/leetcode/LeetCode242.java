package cn.xyf.algorithm.hashtable.leetcode;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 判断两个单词是否为字母异位词
 * @date 2025/2/2 14:39
 */

public class LeetCode242 {

    /*
        1. 拿到字符数组，排序后比较字符数组
     */
    public boolean isAnagram(String s, String t) {
        // 如果两个字符串长度不同，直接返回false
        if (s.length() != t.length()) {
            return false;
        }

        // 将字符串转换为字符数组
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // 对字符数组进行排序
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // 比较排序后的字符数组
        return Arrays.equals(sArray, tArray);
    }

}
