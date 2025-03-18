package cn.xyf.代码随想录.哈希表.两个数组的交集;

import java.util.*;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/16 21:03
 */

public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        List<Integer> resList = new ArrayList<>();

        // 记录nums1中的元素
        for (int num : nums1) {
            map.putIfAbsent(num, true);
        }

        // 检查nums2中的交集
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num)) {
                resList.add(num);
                map.put(num, false); // 防止重复添加
            }
        }

        // 转换为数组
        return resList.stream().mapToInt(i->i).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        // 使用两个HashSet实现去重
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        // 填充第一个集合
        for (int num : nums1) {
            set1.add(num);
        }

        // 检查交集
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num); // 自动去重
            }
        }

        // 集合转数组
        int[] res = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            res[index++] = num;
        }
        return res;
    }
}
