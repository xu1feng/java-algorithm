package cn.xyf.datastruct.binarytree;

/**
 * @author Xuyifeng
 * @description 二叉树遍历 - 递归
 * @date 2025/1/24 15:22
 */

public class TreeTraversal {

    /*
             1
            / \
          2    3
         / \  / \
        4    5   6
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, null), 1, new TreeNode(new TreeNode(5), 3, new TreeNode(6)));
//        preOrder(root);
        inOrder(root);
    }

    /**
     * 前序遍历
     *
     * @param node 节点
     */
    private static void preOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        System.out.print(node.val + "\t"); // 值
        preOrder(node.left); // 左孩子
        preOrder(node.right); // 右孩子
    }

    /**
     * 中序遍历
     *
     * @param node 节点
     */
    private static void inOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + "\t");
        inOrder(node.right);
    }

    /**
     * 后序遍历
     *
     * @param node 节点
     */
    private static void postOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + "\t");
    }

}
