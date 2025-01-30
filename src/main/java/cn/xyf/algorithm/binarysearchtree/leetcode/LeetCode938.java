package cn.xyf.algorithm.binarysearchtree.leetcode;

import java.util.LinkedList;

/**
 * @author Xuyifeng
 * @description 二叉搜索树的范围和
 * @date 2025/1/26 19:22
 */

public class LeetCode938 {

    // 解法一 中序非递归
    public int rangeSumBST1(TreeNode root, int low, int high) {
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                if (pop.val > high) {
                    break;
                }
                // 处理值
                if (pop.val >= low) {
                    sum += pop.val;
                }
                p = pop.right;
            }
        }
        return sum;
    }

    // 解法二 上下限递归
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        // 在范围内，累加
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

}
