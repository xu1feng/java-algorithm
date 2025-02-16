package cn.xyf.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 15:03
 */

public class Leetcode216 {

    /**
     *
     * @param k
     * @param n 代表数字组合后的和
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, n, k, new LinkedList<>(), result);
        return result;
    }

    private static void dfs(int start, int n, int k, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (n == 0 && stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }
        // i = 1,2,3,4
        for (int i = start; i <= 9; i++) {
            // k - stack.length 还差几个能凑满
            // n - i + 1 还剩几个备用数字
//            if (k - stack.size() > 9 - i + 1) {
//                continue;
//            }
            if (n < i) {
                continue;
            }
            if (stack.size() == k) {
                continue;
            }
            stack.push(i); // i = 1
            dfs(i + 1, n - i, k, stack, result);
            stack.pop(); // i = 1 回溯
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Leetcode216().combinationSum3(3, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
