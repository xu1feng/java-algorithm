package cn.xyf.代码随想录.数组.长度最小的子数组;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/6 21:20
 */

public class Leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;          // 窗口左边界
        int sum = 0;         // 当前窗口的和
        int min = Integer.MAX_VALUE;  // 最小长度

        for (int j = 0; j < nums.length; j++) {  // j 是窗口右边界
            sum += nums[j];  // 每次固定移动右边界
            // 当窗口和 >= target 时，尝试缩小左边界
            while (sum >= target) {
                min = Math.min(min, j - i + 1);  // 计算当前窗口长度
                sum -= nums[i];  // 左边界右移前减去对应值
                i++;             // 移动左边界
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;  // 处理无解情况
    }


    public static void main(String[] args) {
        System.out.println(new Leetcode209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new Leetcode209().minSubArrayLen(4, new int[]{1, 4, 4}));
    }
}
