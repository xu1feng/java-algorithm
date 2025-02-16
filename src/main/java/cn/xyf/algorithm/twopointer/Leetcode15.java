package cn.xyf.algorithm.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 21:39
 */

public class Leetcode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        dfs(3, 0, nums.length - 1, 0, nums, new LinkedList<>(), result);
        return result;
    }

    static void dfs(int n, int i, int j, int target, int[] nums, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (n == 2) { // 剩两个数字 -> 两数之和
            twoSum(i, j, nums, target, stack, result);
            return;
        }
        for (int k = i; k < j; k++) {
            // 检查重复
            if (k > i && nums[k] == nums[k - 1]) {
                continue;
            }
            // 固定一个数字，再尝试 n - 1 个数字之和
            stack.push(nums[k]);
            dfs(n - 1, k + 1, j, target - nums[k], nums, stack, result);
            stack.pop();
        }
    }

    static void twoSum(int i, int j, int[] numbers, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else { // 找到解
                ArrayList<Integer> lists = new ArrayList<>(stack);
                lists.add(numbers[i]);
                lists.add(numbers[j]);
                result.add(lists);
                // 继续查找其他解
                i++;
                j--;
                while (i < j && numbers[i] == numbers[i - 1]) {
                    i++;
                }
                while (i < j && numbers[j] == numbers[j + 1]) {
                    j--;
                }
            }
        }
    }

}
