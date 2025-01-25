package cn.xyf.datastruct.deque.leetcode;

import cn.xyf.datastruct.queue.LinkedListQueue;

import java.util.*;

/**
 * @author Xuyifeng
 * @description 二叉树 Z 字层序遍历
 * @date 2025/1/23 09:38
 */

public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // 二叉树没数据
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int c1 = 1; // 当前这一层的节点数
        boolean odd = true; // 奇数层

        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>(); // 每一层的节点数据
            int c2 = 0; // 下一层的节点数
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                if (odd) {
                    level.offerLast(n.val);
                } else {
                    level.offerFirst(n.val);
                }
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }
            odd = !odd;
            result.add(level);
            c1 = c2;
        }
        return result;
    }

}
