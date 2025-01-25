package cn.xyf.datastruct.binarytree.leetcode;

import cn.xyf.datastruct.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Xuyifeng
 * @description 二叉树的后序遍历
 * @date 2025/1/24 16:19
 */

public class LeetCode145 {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode pop = null; // 最近一次出栈的元素
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek(); // 栈顶元素
                if (peek.right == null || pop == peek.right) { // 右子树处理完成
                    pop = stack.pop();
                    result.add(pop.val);
                } else {
                    curr = peek.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, new TreeNode(7)), 1, new TreeNode(new TreeNode(5), 3, new TreeNode(6)));
        System.out.println(postorderTraversal(root));
    }

}
