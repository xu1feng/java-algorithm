package cn.xyf.algorithm.sort.leetcode;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 按照频率将数组排序
 * @date 2025/2/6 20:26
 */

public class LeetCode1636 {

    public int[] frequencySort(int[] nums) {
        // 1. 统计出现频率
        int[] count = new int[201]; // 前100位记录负数
        for (int num : nums) {
            count[num + 100]++;
        }
        // 2. 比较器 按频率升序、再按数值降序
        return Arrays.stream(nums).boxed().sorted((a, b) -> {
            int af = count[a + 100];
            int bf = count[b + 100];
            if (af < bf) {
                return -1;
            } else if (af > bf) {
                return 1;
            } else {
                return b - a;
            }
        }).mapToInt(Integer::intValue).toArray();
    }

}
