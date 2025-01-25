package cn.xyf.datastruct.binarytree.leetcode;

import cn.xyf.datastruct.binarytree.TreeNode;

/**
 * @author Xuyifeng
 * @description 二叉树最大深度 - 使用后序遍历求解
 * @date 2025/1/25 09:39
 */

public class LeetCode104_1 {

    /*
        思路：
        1. 得到左子树深度和右子树深度，二者最大者加一，就是本节点深度
        2. 因为需要得到左右子树深度，很显然是后序遍历典型应用
        3. 关于深度的定义：从根出发，离根最远的节点总边数
            注意：力扣里的深度定义要多一
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int d1 = maxDepth(root.left);
        int d2 = maxDepth(root.right);
        return Integer.max(d1, d2) + 1;
    }

}
