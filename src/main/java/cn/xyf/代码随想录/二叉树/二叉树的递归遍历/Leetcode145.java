package cn.xyf.代码随想录.二叉树.二叉树的递归遍历;

import cn.xyf.代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description 二叉树的后序遍历
 * @date 2025/3/27 20:53
 */

public class Leetcode145 {

    private void Postorder(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        Postorder(treeNode.left, result);
        Postorder(treeNode.right, result);
        result.add(treeNode.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Postorder(root,result);
        return result;
    }

}
