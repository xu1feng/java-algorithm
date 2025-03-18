package cn.xyf.代码随想录.哈希表.有效的字母异位词;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/12 21:28
 */

public class Leetcode242 {

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

    public boolean isAnagram2(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
