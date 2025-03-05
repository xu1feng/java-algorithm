package cn.xyf.代码随想录.数组.移除元素;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/5 21:08
 */

public class Leetcode27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode27().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
