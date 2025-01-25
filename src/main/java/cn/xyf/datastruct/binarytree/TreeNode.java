package cn.xyf.datastruct.binarytree;

/**
 * @author Xuyifeng
 * @description 树节点类
 * @date 2025/1/24 15:01
 */

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, int val, TreeNode right) {
        this.left = left;
        this.val = val;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
