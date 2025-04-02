package cn.xyf.代码随想录.二叉树.二叉树的层序遍历.相关题目推荐;

import cn.xyf.代码随想录.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/4/2 21:42
 */

public class Leetcode104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (len == 0) {
                    cnt++;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return cnt;
    }

}
