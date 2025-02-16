package cn.xyf.algorithm.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 22:04
 */

public class Leetcode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // 排序以跳过重复元素
        List<List<Integer>> result = new LinkedList<>();
        // 将 target 转换为 long 类型，防止后续计算溢出
        dfs(4, 0, nums.length - 1, (long) target, nums, new LinkedList<>(), result);
        return result;
    }

    // 修改 target 参数为 long 类型
    static void dfs(int n, int i, int j, long target, int[] nums, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (n == 2) {
            // 调用两数之和时传递 long 类型的 target
            twoSum(i, j, nums, target, stack, result);
            return;
        }
        // 遍历时跳过重复元素
        for (int k = i; k <= j - (n - 1); k++) { // 注意循环条件中的范围
            if (k > i && nums[k] == nums[k - 1]) continue; // 去重
            stack.addLast(nums[k]);
            // 递归时计算新的 target，用 long 防止溢出
            dfs(n - 1, k + 1, j, target - (long) nums[k], nums, stack, result);
            stack.removeLast();
        }
    }

    // 修改 target 参数为 long 类型
    static void twoSum(int i, int j, int[] numbers, long target, LinkedList<Integer> stack, List<List<Integer>> result) {
        while (i < j) {
            // 将求和计算转换为 long 避免溢出
            long sum = (long) numbers[i] + (long) numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                // 找到有效四元组
                List<Integer> list = new ArrayList<>(stack);
                list.add(numbers[i]);
                list.add(numbers[j]);
                result.add(list);
                // 跳过重复元素
                i++;
                j--;
                while (i < j && numbers[i] == numbers[i - 1]) i++;
                while (i < j && numbers[j] == numbers[j + 1]) j--;
            }
        }
    }

}
