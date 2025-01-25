package cn.xyf.datastruct.binarytree.leetcode;

import cn.xyf.datastruct.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Xuyifeng
 * @description 二叉树的前序遍历 - 非递归
 * @date 2025/1/24 15:46
 */

public class LeetCode144 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode curr = root; // 代表当前节点
        // 利用 栈，记录来时的路
        Stack<TreeNode> stack = new Stack<>();
        // 一直往左下走
        while (curr != null || !stack.isEmpty()) {
            // 左边的路没走完
            if (curr != null) {
                // System.out.println("去: " + curr.val); // 去的结果是前序遍历
                result.add(curr.val);
                stack.push(curr); // 压入栈
                curr = curr.left;
            } else { // 左边的路走到头，往回走
                TreeNode pop = stack.pop();
                // System.out.println("回: " + pop.val); // 回的结果是中序遍历
                curr = pop.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, null), 1, new TreeNode(new TreeNode(5), 3, new TreeNode(6)));
        System.out.println(preorderTraversal(root));
    }

}
