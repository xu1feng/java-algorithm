package cn.xyf.代码随想录.哈希表.四数相加Ⅱ;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/17 21:57
 */

public class Leetcode454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(- i - j, 0);
            }
        }
        return res;
    }

}
