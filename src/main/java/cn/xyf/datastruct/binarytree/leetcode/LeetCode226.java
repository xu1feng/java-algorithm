package cn.xyf.datastruct.binarytree.leetcode;

import cn.xyf.datastruct.binarytree.TreeNode;

/**
 * @author Xuyifeng
 * @description 翻转二叉树
 * @date 2025/1/25 10:36
 */

public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        fn(root);
        return root;
    }

    private static void fn(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;

        fn(node.left);
        fn(node.right);
    }

}
