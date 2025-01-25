package cn.xyf.datastruct.queue.leetcode;

import cn.xyf.datastruct.queue.LinkedListQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Xuyifeng
 * @date: 2025/1/21 16:38
 * @description: 二叉树的层序遍历
 */

public class LeetCode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int c1 = 1; // 当前这一层的节点数

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>(); // 每一层的节点数据
            int c2 = 0; // 下一层的节点数
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                level.add(n.val);
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }
            result.add(level);
            c1 = c2;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);

        int c1 = 1; // 当前这一层的节点数

        while (!queue.isEmpty()) {
            int c2 = 0; // 下一层的节点数
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                System.out.print(n + " ");
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }
            System.out.println();
            c1 = c2;
        }
    }

}
