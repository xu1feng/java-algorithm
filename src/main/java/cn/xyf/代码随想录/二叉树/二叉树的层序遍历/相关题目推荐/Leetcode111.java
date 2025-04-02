package cn.xyf.代码随想录.二叉树.二叉树的层序遍历.相关题目推荐;

import cn.xyf.代码随想录.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/4/2 21:55
 */

public class Leetcode111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0; // 如果根节点为空，直接返回深度为0
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 在每次获取每层节点个数之后计算深度
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // 若某层节点是叶子节点，返回深度，因为此时的depth刚好是该层的深度
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }

}
