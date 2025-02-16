package cn.xyf.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 14:31
 */

public class Leetcode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, new boolean[candidates.length], candidates, target, new LinkedList<>(), result);
        return result;
    }

    private static void dfs(int start, boolean[] visited, int[] candidates, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(stack));
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            // 剪枝
            if (target < candidate) {
                continue;
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            stack.push(candidate);
            dfs(i + 1, visited, candidates, target - candidate, stack, result);
            stack.pop();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = new Leetcode40().combinationSum2(candidates, 8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
