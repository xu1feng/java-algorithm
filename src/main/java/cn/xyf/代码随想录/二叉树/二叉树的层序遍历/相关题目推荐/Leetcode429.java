package cn.xyf.代码随想录.二叉树.二叉树的层序遍历.相关题目推荐;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/4/1 21:54
 */

public class Leetcode429 {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return List.of(); // 处理空树情况
        List<List<Integer>> ans = new ArrayList<>(); // 结果列表
        Queue<Node> q = new ArrayDeque<>(); // BFS队列
        q.add(root); // 根节点入队

        while (!q.isEmpty()) { // 逐层处理
            int n = q.size(); // 当前层节点数
            List<Integer> vals = new ArrayList<>(n); // 预分配空间优化

            while (n-- > 0) { // 处理当前层所有节点
                Node node = q.poll(); // 取出节点
                vals.add(node.val); // 记录节点值
                q.addAll(node.children); // 子节点入队（保持顺序）
            }
            ans.add(vals); // 当前层结果存入答案
        }
        return ans;
    }

}
