package cn.xyf.代码随想录.哈希表.有效的字母异位词.相关题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/13 21:36
 */

public class Leetcode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> strings = map.computeIfAbsent(key, k -> new ArrayList<>());
            strings.add(str);
        }
        return new ArrayList<>(map.values());
    }

}
