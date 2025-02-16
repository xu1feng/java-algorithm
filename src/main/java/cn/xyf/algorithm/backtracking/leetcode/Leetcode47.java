package cn.xyf.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 13:30
 */

public class Leetcode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) { // 找出重复数字
                continue;
            }
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
        List<List<Integer>> permuted = new Leetcode47().permuteUnique(new int[]{1, 1, 3});
        for (List<Integer> list : permuted) {
            System.out.println(list);
        }
    }

}
