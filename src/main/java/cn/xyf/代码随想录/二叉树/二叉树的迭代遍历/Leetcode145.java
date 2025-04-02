package cn.xyf.代码随想录.二叉树.二叉树的迭代遍历;

import cn.xyf.代码随想录.二叉树.TreeNode;

import java.util.*;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/27 21:22
 */

public class Leetcode145 {

    // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果（左-右-中）
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (null != node.left) {
                stack.push(node.left);
            }
            if (null != node.right) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

}
