package cn.xyf.datastruct.binarytree.leetcode;

import cn.xyf.datastruct.binarytree.TreeNode;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 从前序与中序遍历序列构造二叉树
 * @date 2025/1/25 11:33
 */

public class LeetCode105 {

    /*
        preOrder = {1, 2, 4, 3, 6, 7}
        inOrder = {4, 2, 1, 6, 3, 7}

        根 1
            pre     in
        左  2,4     4,2
        右  3,6,7   6,3,7

        根 2
        左 4

        根 3
        左 6
        右 7
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 创建根节点
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        // 区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                // 0 ~ i-1  左子树
                // i+1 ~ inOrder.length-1   右子树
                // Arrays.copyOfRange 左闭右开
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i); // [4,2]
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length); // [6,3,7]

                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1); // [2,4]
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length); // [3,6,7]

                root.left = buildTree(preLeft, inLeft); // 2
                root.right = buildTree(preRight, inRight); // 3
                break;
            }
        }
        return root;
    }

}
