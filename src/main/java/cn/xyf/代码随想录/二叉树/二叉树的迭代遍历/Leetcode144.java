package cn.xyf.代码随想录.二叉树.二叉树的迭代遍历;

import cn.xyf.代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/27 21:06
 */

public class Leetcode144 {

    // 前序遍历顺序：中 - 左 - 右，入栈顺序：中 - 右 - 左
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop(); // 中
            res.add(node.val);
            if (null != node.right) {
                stack.push(node.right); // 右
            }
            if (null != node.left) {
                stack.push(node.left); // 左
            }
        }
        return res;
    }

}
