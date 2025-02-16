package cn.xyf.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 13:43
 */

public class Leetcode77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, n, k, new LinkedList<>(), result);
        return result;
    }

    /**
     *
     * @param start 起始处理数字
     * @param n
     * @param k
     * @param stack 每次处理的结果
     * @param result 最终的结果
     */
    private static void dfs(int start, int n, int k, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }
        // i = 1,2,3,4
        for (int i = start; i <= n; i++) {
            // k - stack.length 还差几个能凑满
            // n - i + 1 还剩几个备用数字
            if (k - stack.size() > n - i + 1) {
                continue;
            }
            stack.push(i); // i = 1
            dfs(i + 1, n, k, stack, result);
            stack.pop(); // i = 1 回溯
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Leetcode77().combine(4, 3);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }

}
