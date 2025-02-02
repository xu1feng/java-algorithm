package cn.xyf.algorithm.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author Xuyifeng
 * @description 最常见的单词
 * @date 2025/2/2 15:06
 */

public class LeetCode819 {

    private static void put(Set<String> banSet, HashMap<String, Integer> map, StringBuilder sb) {
        if (sb.length() > 0) {
            String key = sb.toString();
            if(!banSet.contains(key)) {
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
    }

    public String mostCommonWord3(String paragraph, String[] banned) {
        Set<String> banSet = Set.of(banned);
        HashMap<String, Integer> map = new HashMap<>();
        char[] chars = paragraph.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else {
                put(banSet, map, sb);
                sb = new StringBuilder();
            }
        }
        put(banSet, map, sb);

        Integer max = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            Integer value = e.getValue();
            if (value > max) {
                max = value;
                maxKey = e.getKey();
            }
        }
        return maxKey;
    }

    public String mostCommonWord2(String paragraph, String[] banned) {
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
        Set<String> set = Set.of(banned);
        HashMap<String, Integer> map = new HashMap<>();
        for (String key : split) {
            if (!set.contains(key)) {
                map.compute(key, (k, v) -> v == null ? 0 : v + 1);
            }
        }
        int max = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            Integer value = e.getValue();
            if (value > max) {
                max = value;
                maxKey = e.getKey();
            }
        }
        return maxKey;
    }

    /*
        1. 将 paragraph 截取成一个个单词
        2. 将单词加入 map 集合，单词本身作为 key，出现次数作为 value，避免禁用词加入
        3. 在 map 集合中找到 value 最大的，返回它对应的 key 即可
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
        Set<String> set = Set.of(banned);
        HashMap<String, Integer> map = new HashMap<>();
        for (String key : split) {
//            Integer value = map.get(key);
//            if (value == null) {
//                value = 0;
//            }
//            map.put(key, value + 1);
            if (!set.contains(key)) {
                map.compute(key, (k, v) -> v == null ? 0 : v + 1);
            }
        }
        Optional<Map.Entry<String, Integer>> max = map.entrySet().stream().max(Map.Entry.comparingByValue());
        return max.map(Map.Entry::getKey).orElse(null);
    }

}
