package cn.xyf.datastruct.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Xuyifeng
 * @description 二叉树遍历非递归模板
 * @date 2025/1/24 16:40
 */

public class TreeTraversalNonRecursiveTemplate {

    public static void traversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode pop = null; // 最近一次出栈的元素
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                System.out.println("前: " + curr.val);
                // 待处理左子树
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek(); // 栈顶元素
                // 没有右子树
                if (peek.right == null) {
                    System.out.println("中: " + peek.val);
                    pop = stack.pop();
                    System.out.println("后: " + pop.val);
                } else if (pop == peek.right) { // 右子树处理完成
                    pop = stack.pop();
                    System.out.println("后: " + pop.val);
                } else { // 待处理右子树
                    System.out.println("中: " + peek.val);
                    curr = peek.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, new TreeNode(7)), 1, new TreeNode(new TreeNode(5), 3, new TreeNode(6)));
        traversal(root);
    }

}
