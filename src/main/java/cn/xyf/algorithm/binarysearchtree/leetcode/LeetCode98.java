package cn.xyf.algorithm.binarysearchtree.leetcode;

import java.util.LinkedList;

/**
 * @author Xuyifeng
 * @description 验证二叉搜索树
 * @date 2025/1/26 18:26
 */

public class LeetCode98 {

    public boolean isValidBST(TreeNode root) {
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE; // 代表上一个值
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                // 处理值
                if (prev >= pop.val) {
                    return false;
                }
                prev = pop.val;
                p = pop.right;
            }
        }
        return true;
    }

    long prev = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean a = isValidBST2(root.left);
        if (prev >= root.val) {
            return false;
        }
        prev = root.val;
        boolean b = isValidBST2(root.right);
        return a && b;
    }

}
