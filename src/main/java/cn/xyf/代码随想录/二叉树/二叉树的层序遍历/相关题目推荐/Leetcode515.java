package cn.xyf.代码随想录.二叉树.二叉树的层序遍历.相关题目推荐;

import cn.xyf.代码随想录.二叉树.TreeNode;

import java.util.*;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/4/2 21:12
 */

public class Leetcode515 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> itemList = new ArrayList<>();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                itemList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            Integer max = itemList.stream().max(Integer::compareTo).get();
            res.add(max);
        }
        return res;
    }
}
