package cn.xyf.代码随想录.二叉树.二叉树的层序遍历.相关题目推荐;

import cn.xyf.代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/31 21:44
 */

public class Leetcode199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 当前层的节点个数
            int len = queue.size();

            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (len == 0) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

}
