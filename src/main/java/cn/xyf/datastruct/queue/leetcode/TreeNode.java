package cn.xyf.datastruct.queue.leetcode;

/**
 * @author: Xuyifeng
 * @date: 2025/1/21 16:39
 * @description: 二叉树节点
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
