package cn.xyf.datastruct.binarytree.leetcode;

import cn.xyf.datastruct.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Xuyifeng
 * @description 二叉树的中序遍历 - 非递归
 * @date 2025/1/24 16:15
 */

public class LeetCode94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                curr = pop.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, null), 1, new TreeNode(new TreeNode(5), 3, new TreeNode(6)));
        System.out.println(inorderTraversal(root));
    }

}
