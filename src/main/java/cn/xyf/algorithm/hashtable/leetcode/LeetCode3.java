package cn.xyf.algorithm.hashtable.leetcode;

import java.util.HashMap;

/**
 * @author Xuyifeng
 * @description 最长不重复子串
 * @date 2025/2/2 13:12
 */

public class LeetCode3 {

    /*
        要点：
            1. 用 begin 和 end 表示子串开始和结束位置
            2. 用 hash 表检查重复字符
            3. 从左向右查看每个字符，如果
                - 没遇到重复字符，调整 end
                - 遇到重复字符，调整 begin
                - 将当前字符放入 hash 表
            4. end - begin + 1 是当前子串长度
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) { // 重复
                begin = Math.max(map.get(c) + 1, begin);
                map.put(c, end);
            } else {
                map.put(c, end);
            }
            maxLength = Math.max(maxLength, end - begin + 1);
        }
        return maxLength;
    }

}
