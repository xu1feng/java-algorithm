package cn.xyf.datastruct.binarytree.leetcode;

import cn.xyf.datastruct.binarytree.TreeNode;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 从中序与后序遍历序列构造二叉树
 * @date 2025/1/25 11:55
 */

public class LeetCode106 {

    /*
        inorder = {4,2,1,6,3,7}
        postorder = {4,2,6,7,3,1}

        根 1
           in           post
        左 4,2           4,2
        右 6,3,7        6,7,3

        根 2
        左 4

        根 3
        左 6
        右 7
     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        // 根节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        // 切分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);

                root.left = buildTree(inLeft, postLeft);
                root.right = buildTree(inRight, postRight);
                break;
            }
        }
        return root;
    }

}
