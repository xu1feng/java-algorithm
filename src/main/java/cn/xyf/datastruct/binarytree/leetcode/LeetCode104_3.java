package cn.xyf.datastruct.binarytree.leetcode;

import cn.xyf.datastruct.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xuyifeng
 * @description 二叉树最大深度 - 使用层序遍历
 * @date 2025/1/25 10:03
 */

public class LeetCode104_3 {

    /*
        思路：
        1. 使用层序遍历，层数即最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // 如果根节点为空，直接返回深度为0
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
//        int c1 = 1; // 记录每层有几个元素
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
//            int c2 = 0; // 下一层元素个数
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
//                    c2++;
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
//                    c2++;
                    queue.offer(poll.right);
                }
            }
//            c1 = queue.size();
            height++;
        }
        return height;
    }

}
