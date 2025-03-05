package cn.xyf.代码随想录.数组.移除元素.相关题目推荐;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/5 21:28
 */

public class Leetcode26 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow] && nums[fast - 1] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode26().removeDuplicates(new int[]{1,1,2}));
    }
}
