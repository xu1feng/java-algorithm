package cn.xyf.algorithm.hashtable.leetcode;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/2 14:51
 */

public class LeetCode387 {

    public int firstUniqChar(String s) {
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            array[ch - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (array[ch - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
