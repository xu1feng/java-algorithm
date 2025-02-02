package cn.xyf.algorithm.hashtable.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Xuyifeng
 * @description 字母异位词分组
 * @date 2025/2/2 13:35
 */

public class LeetCode49 {

    /*
        思路：
        1. 遍历字符串数组，每个字符串中的字符重新排序后作为 hash 表的 key
        2. 所谓分组，其实就是准备一个集合，把这些单词加入到 key 相同的集合中，作为 hash 表的 value
        3. 返回分组结果
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

}
