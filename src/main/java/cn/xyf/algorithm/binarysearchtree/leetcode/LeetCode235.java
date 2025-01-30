package cn.xyf.algorithm.binarysearchtree.leetcode;

/**
 * @author Xuyifeng
 * @description 二叉搜索树的最近公共祖先(祖先也包括自己)
 * @date 2025/1/26 21:26
 */

public class LeetCode235 {

    /*
        待查找节点 p q 在某一结点的两侧，那么此节点就是最近的公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = root;
        while (p.val < a.val && q.val < a.val || a.val < p.val && a.val < q.val) { // p q 都在结点左侧 || p q 都在结点右侧
            if (p.val < a.val) {
                a = a.left;
            } else {
                a = a.right;
            }
        }
        return a;
    }

}
