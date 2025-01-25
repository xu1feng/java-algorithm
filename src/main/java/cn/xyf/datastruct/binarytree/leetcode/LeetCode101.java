package cn.xyf.datastruct.binarytree.leetcode;

import cn.xyf.datastruct.binarytree.TreeNode;

/**
 * @author Xuyifeng
 * @description 对称二叉树
 * @date 2025/1/24 17:12
 */

public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {
        // 如果根节点为空，直接返回 true
        if (root == null) {
            return true;
        }
        // 检查左右子树是否对称
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        // 如果两个节点都为空，说明对称
        if (left == null && right == null) {
            return true;
        }
        // 如果其中一个节点为空，另一个不为空，说明不对称
        if (left == null || right == null) {
            return false;
        }
        // 如果两个节点的值不相等，说明不对称
        if (left.val != right.val) {
            return false;
        }
        // 递归检查左子树的左节点和右子树的右节点，以及左子树的右节点和右子树的左节点
        return check(left.left, right.right) && check(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(new TreeNode(new TreeNode(3), 2, new TreeNode(4)), 1, new TreeNode(new TreeNode(4), 2, new TreeNode(3)));
        System.out.println(new LeetCode101().isSymmetric(root1));

        TreeNode root2 = new TreeNode(new TreeNode(null, 2, new TreeNode(3)), 1, new TreeNode(null, 2, new TreeNode(3)));
        System.out.println(new LeetCode101().isSymmetric(root2));
    }

}
