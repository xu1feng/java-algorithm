package cn.xyf.datastruct.binarytree.leetcode;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Xuyifeng
 * @description 根据后缀表达式构造表达式树
 * @date 2025/1/25 11:14
 */

public class PostExpression2Tree {

    /*
        中缀表达式               (2-1)*3
        后缀（逆波兰）表达式       21-3*

        思路：
        1. 遇到数字入栈
        2. 遇到运算符出栈，建立节点关系，再入栈

            栈
          |   |
          | 3 |
          | - |
          -----

          "-".right = 1
          "-".left = 2

          "*".right = 3
          "*".left = "-"

        表达式树
                *
              /  \
             -    3
           /  \
          2    1
     */

    public TreeNode constructExpressionTree(String[] tokens) {
        Stack<TreeNode> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+", "-", "*", "/" -> { // 运算符
                    TreeNode right = stack.pop(); // 先出栈的是右操作数
                    TreeNode left = stack.pop();
                    TreeNode root = new TreeNode(token);
                    root.left = left;
                    root.right = right;
                    stack.push(root); // 与其他节点建立关系
                }
                default -> { // 数字
                    stack.push(new TreeNode(token));
                }
            }
        }
        return stack.peek();
    }

    private static class TreeNode {
        public String val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, String val, TreeNode right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }

}
