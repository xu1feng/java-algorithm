package cn.xyf.algorithm.string;

/**
 * @author Xuyifeng
 * @description 最小覆盖子串
 * @date 2025/2/17 09:45
 */

public class Leetcode76 {

    static class Result {
        int i;
        int j;

        public Result(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    /*
        思路
        1. 统计目标串需要各种字符个数，统计原始串i~j 范围各种字符个数
        2. 如果原始串 i~j 范围内不满足条件，j++ 扩大范围，直到满足条件 j 停下来
        3. 一旦满足条件 i++ 缩小范围，直到再次不满足条件
        4. 重复 第2，3步，直至 j 到达原始串末尾
     */
    public String minWindow(String s, String t) {
        char[] target = t.toCharArray();
        int[] targetCount = new int[128];
        for (char c : target) {
            targetCount[c]++;
        }
        int passTotal = 0; // 条件总数
        for (int count : targetCount) {
            if (count > 0) {
                passTotal++;
            }
        }

        int passed = 0; // 已经通过的条件数

        char[] source = s.toCharArray();
        int[] sourceCount = new int[128]; // 原始字符串i~j范围内字符各出现几次
        int i = 0;
        int j = 0;
        Result res = null;
        while (j < source.length) {
            char right = source[j];
            sourceCount[right]++;

            if (sourceCount[right] == targetCount[right]) {
                passed++;
            }
            // 若以满足所有条件，缩小 i 范围，更新范围内的字符计数和通过条件数
            while (passed == passTotal && i <= j) {
                if (res == null) {
                    res = new Result(i, j);
                } else {
                    if (j - i < res.j - res.i) {
                        res = new Result(i, j);
                    }
                }
                char left = source[i];
                sourceCount[left]--;
                if (sourceCount[left] < targetCount[left]) {
                    passed--;
                }
                i++;
            }
            j++;
        }
        return res == null ? "" : new String(source, res.i, res.j - res.i + 1);
    }

}
