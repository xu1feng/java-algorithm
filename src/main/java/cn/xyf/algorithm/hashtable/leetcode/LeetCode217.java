package cn.xyf.algorithm.hashtable.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Xuyifeng
 * @description 存在重复元素
 * @date 2025/2/2 14:01
 */

public class LeetCode217 {

    public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, num);
            }
        }
        return false;
    }

}
