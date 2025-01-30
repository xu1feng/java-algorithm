package cn.xyf.algorithm.binarysearchtree.leetcode;

import cn.xyf.algorithm.binarysearchtree.BinarySearchTree1;

/**
 * @author Xuyifeng
 * @description 删除二叉搜索树中的节点
 * @date 2025/1/26 17:42
 */

public class LeetCode450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode p = root;
        TreeNode parent = null;
        while (p != null) {
            if (key < p.val) {
                parent = p;
                p = p.left;
            } else if (key > p.val) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return root; // 没有找到要删除的节点，直接返回原树
        }
        // 删除操作
        if (p.left == null) {
            // 情况1：删除节点没有左孩子，将右孩子托孤给 parent
            root = shift(root, parent, p, p.right);
        } else if (p.right == null) {
            // 情况2：删除节点没有右孩子，将左孩子托孤给 parent
            root = shift(root, parent, p, p.left);
        } else {
            // 情况4：删除节点左右孩子都有
            TreeNode s = p.right;
            TreeNode sParent = p; // 后继节点父亲
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            // s 为后继节点
            if (sParent != p) { // 不相邻
                // 删除节点和后继节点不相邻，处理后继节点的后事
                shift(root, sParent, s, s.right); // 不可能有左孩子 因为后继节点是右子树最左下节点
                s.right = p.right;
            }
            // 后继节点取代被删除节点
            root = shift(root, parent, p, s);
            s.left = p.left;
        }
        return root; // 返回更新后的树的根节点
    }

    /**
     * 托孤方法
     * @param root 当前树的根节点
     * @param parent 被删除节点的父亲
     * @param deleted 被删除节点
     * @param child 被顶上去的节点
     * @return 新的根节点
     */
    private TreeNode shift(TreeNode root, TreeNode parent, TreeNode deleted, TreeNode child) {
        if (parent == null) { // 被删除的是根节点
            return child; // 返回新的根节点
        } else if (deleted == parent.left) {
            parent.left = child;
        } else if (deleted == parent.right) {
            parent.right = child;
        }
        return root; // 返回原根节点
    }

    // 递归解法
    public TreeNode deleteNode2(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.val) {
            node.left = deleteNode(node.left, key);
            return node;
        }
        if (node.val < key) {
            node.right = deleteNode(node.right, key);
            return node;
        }
        if (node.left == null) { // 情况1 - 只有右孩子
            return node.right;
        }
        if (node.right == null) { // 情况2 - 只有左孩子
            return node.left;
        }
        TreeNode s = node.right; // 情况3 - 有两个孩子
        while (s.left != null) {
            s = s.left;
        }
        s.right = deleteNode(node.right, s.val);
        s.left = node.left;
        return s;
    }
}
