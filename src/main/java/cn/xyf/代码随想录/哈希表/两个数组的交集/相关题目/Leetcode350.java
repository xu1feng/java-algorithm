package cn.xyf.代码随想录.哈希表.两个数组的交集.相关题目;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/16 21:25
 */

public class Leetcode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int num : nums1) {
            map1.compute(num, (k,v) -> (v == null) ? 1 : v + 1);
        }
        for (int num : nums2) {
            map2.compute(num, (k,v) -> (v == null) ? 1 : v + 1);
        }

        for (Integer key1 : map1.keySet()) {
            if (map2.containsKey(key1)) {
                if (map2.get(key1) == map1.get(key1)) {
                    int cnt = map1.get(key1);
                    while (cnt-- > 0) {
                        res.add(key1);
                    }
                } else {
                    int cnt = Math.min(map1.get(key1), map2.get(key1));
                    while (cnt-- > 0) {
                        res.add(key1);
                    }
                }
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

}
