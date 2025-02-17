package cn.xyf.algorithm.monotonicstack;

import java.util.LinkedList;

/**
 * @author Xuyifeng
 * @description 接雨水 - 单调栈
 * @date 2025/2/16 13:48
 */

public class Leetcode42 {

    static class Data {
        int height;
        int i; // 索引

        public Data(int height, int i) {
            this.height = height;
            this.i = i;
        }
    }

    /*
        思路
        1. 维护一个单调栈
        2. 当加入一个新元素时，如果发现需要弹出元素，表示遇到了一个凹陷的位置，此时应该计算雨水容量
     */
    public int trap(int[] heights) {
        int sum = 0;
        LinkedList<Data> stack = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            Data right = new Data(heights[i], i);
            while (!stack.isEmpty() && stack.peek().height < right.height) {
                Data pop = stack.pop();
                Data left = stack.peek();
                if (left != null) { // 计算水的容量
                    int width = right.i - left.i - 1;
                    int height = Math.min(left.height, right.height) - pop.height;
                    sum += width * height;
                }
            }
            stack.push(right);
        }
        return sum;
    }

}
