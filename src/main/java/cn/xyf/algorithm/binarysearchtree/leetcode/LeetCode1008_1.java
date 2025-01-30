package cn.xyf.algorithm.binarysearchtree.leetcode;

/**
 * @author Xuyifeng
 * @description 前序遍历构造二叉树
 * @date 2025/1/26 20:08
 */

public class LeetCode1008_1 {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            int val = preorder[i];
            insert(root, val); // nlog(n)
        }
        return root;
    }

    private TreeNode insert(TreeNode node, int val) {
        if (node == null) { // 找到空位
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

}
