package cn.xyf.代码随想录.二叉树.二叉树的递归遍历;

import cn.xyf.代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description 二叉树的前序遍历
 * @date 2025/3/26 21:57
 */

public class Leetcode144 {

    private void preOrder(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        result.add(treeNode.val); // 根
        preOrder(treeNode.left, result); // 左
        preOrder(treeNode.right, result); // 右
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

}
