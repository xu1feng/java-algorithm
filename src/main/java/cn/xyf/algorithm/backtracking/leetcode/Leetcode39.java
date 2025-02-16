package cn.xyf.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 14:14
 */

/**
 * 与之前的零钱兑换问题其实是一样的，只是
 * <ul>
 *     <li>本题求的是：所有组合的具体信息</li>
 *     <li>零钱兑换问题求的是：所有组合中数字最少的、所有组合个数</li>
 * </ul>
 */
public class Leetcode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, candidates, target, new LinkedList<>(), result);
        return result;
    }

    private static void dfs(int start, int[] candidates, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(stack));
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            // 剪枝
            if (target < candidate) {
                continue;
            }
            stack.push(candidate);
            dfs(i, candidates, target - candidate, stack, result);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Leetcode39().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
