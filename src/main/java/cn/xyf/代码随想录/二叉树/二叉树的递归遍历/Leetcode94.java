package cn.xyf.代码随想录.二叉树.二叉树的递归遍历;

import cn.xyf.代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description 二叉树的中序遍历
 * @date 2025/3/27 20:56
 */

public class Leetcode94 {

    private void Inorder(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        Inorder(treeNode.left, result);
        result.add(treeNode.val);
        Inorder(treeNode.right, result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Inorder(root, result);
        return result;
    }

}
