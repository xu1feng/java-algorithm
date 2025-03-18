package cn.xyf.代码随想录.哈希表.两数之和;

import java.util.HashMap;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/17 21:31
 */

public class Leetcode1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = target - x;
            if (map.containsKey(y)) {
                return new int[] {i, map.get(y)};
            } else {
                map.put(x, i);
            }
        }
        return null;
    }

}
