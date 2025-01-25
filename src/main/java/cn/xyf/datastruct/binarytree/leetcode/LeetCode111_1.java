package cn.xyf.datastruct.binarytree.leetcode;

import cn.xyf.datastruct.binarytree.TreeNode;

/**
 * @author Xuyifeng
 * @description 二叉树的最小深度
 * @date 2025/1/25 10:23
 */

public class LeetCode111_1 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d1 = minDepth(root.left);
        int d2 = minDepth(root.right);
        if (d2 == 0) { // 当右子树为空
            return d1 + 1;
        }
        if (d1 == 0) { // 当左子树为空
            return d2 + 1;
        }
        return Integer.min(d1, d2) + 1;
    }

}
