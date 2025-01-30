package cn.xyf.algorithm.binarysearchtree.leetcode;

/**
 * @author Xuyifeng
 * @description 二叉搜索树中的插入操作
 * @date 2025/1/26 17:53
 */

public class LeetCode701 {

    /*
        题目前提：val 一定与树中节点不同
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) { // 找到空位
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

}
