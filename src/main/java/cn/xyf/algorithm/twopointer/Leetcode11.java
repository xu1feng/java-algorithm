package cn.xyf.algorithm.twopointer;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 22:27
 */

public class Leetcode11 {

    /*
        向中间不断缩减距离
        每次改变较短的挡板
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                int area = (j - i) * height[i];
                max = Math.max(max, area);
                i++;
            } else {
                int area = (j - i) * height[j];
                max = Math.max(max, area);
                j--;
            }
        }
        return max;
    }

}
