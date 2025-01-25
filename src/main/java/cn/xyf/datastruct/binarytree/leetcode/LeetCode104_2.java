package cn.xyf.datastruct.binarytree.leetcode;

import cn.xyf.datastruct.binarytree.TreeNode;

import java.util.Stack;

/**
 * @author Xuyifeng
 * @description 二叉树最大深度 - 使用后序遍历（非递归）求解
 * @date 2025/1/25 09:52
 */

public class LeetCode104_2 {

    /*
        思路：
        1. 使用非递归后序遍历，栈的最大高度即为最大深度
     */
    public int maxDepth(TreeNode root) {
        TreeNode curr = root;
        TreeNode pop = null; // 最近一次的出栈元素
        Stack<TreeNode> stack = new Stack<>();
        int max = 0; // 栈的最大高度
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                int size = stack.size();
                if (size > max) {
                    max = size;
                }
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                } else {
                    curr = peek.right;
                }
            }
        }
        return max;
    }

}
