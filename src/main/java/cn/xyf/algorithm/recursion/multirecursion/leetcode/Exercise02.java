package cn.xyf.algorithm.recursion.multirecursion.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Xuyifeng
 * @date: 2025/1/19 16:49
 * @description: 杨辉三角 - LeetCode118
 */

public class Exercise02 {

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        System.out.println(result);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> cache = new ArrayList<>();
        for (int i = 0; i < numRows; i++) { // 行
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(0); // 先初始化为0
            }
            cache.add(row);
        }
        for (int i = 0; i < numRows; i++) { // 行
            for (int j = 0; j <= i; j++) {
                cache.get(i).set(j, element(i, j, cache)); // 再填充值
            }
        }
        return cache;
    }

    private static int element(int i, int j, List<List<Integer>> cache) {
        if (cache.get(i).get(j) > 0)
            return cache.get(i).get(j);

        if (0 == j || i == j) {
            cache.get(i).set(j, 1);
            return 1;
        }
        int value = element(i - 1, j - 1, cache) + element(i - 1, j, cache);
        cache.get(i).set(j, value);
        return value;
    }
}
