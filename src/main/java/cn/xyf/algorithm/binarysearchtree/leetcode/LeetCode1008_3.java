package cn.xyf.algorithm.binarysearchtree.leetcode;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/1/26 21:13
 */

public class LeetCode1008_3 {

    /*
        分治法

        8, 5, 1, 7, 10, 12

        根 8 左 5, 1, 7 右 10, 12
        根 5 左 1 右 7
        根 10 左 null 右 12
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return partition(preorder, 0, preorder.length - 1);
    }

    private TreeNode partition(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = start + 1;
        while (index <= end) {
            if (preorder[index] > preorder[start]) { // 找到第一个比根节点大的值 就是右子树的起点
                break;
            }
            index++;
        }
        root.left = partition(preorder, start + 1, index - 1);
        root.right = partition(preorder, index, end);
        return root;
    }

}
