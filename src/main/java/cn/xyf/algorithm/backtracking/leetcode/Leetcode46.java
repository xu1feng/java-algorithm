package cn.xyf.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description 全排列 - 回溯
 * @date 2025/2/14 20:16
 */

public class Leetcode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new LinkedList<>(), result);
        return result;
    }

    private static void dfs(int[] nums, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }
        // 遍历 nums 数组，发现没有被使用的数字，则将其标记为使用，并加入 stack
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                stack.push(nums[i]);
                dfs(nums, visited, stack, result);
                visited[i] = false;
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Leetcode46().permute(new int[]{1, 2, 3});
        for (List<Integer> s : permute) {
            System.out.println(s);
        }
    }

}
