package cn.xyf.algorithm.binarysearchtree.leetcode;

/**
 * @author Xuyifeng
 * @description 前序遍历构造二叉树
 * @date 2025/1/26 20:49
 */

public class LeetCode1008_2 {

    /*
        上限法
        1. 遍历数组中每一个值，根据值创建节点
            - 每个节点若成功创建都有：左孩子上限，右孩子上限
        2. 处理下一个值时，如果超过此上限，那么
            - 将 null 作为上个节点的孩子
            - 不能创建节点对象
            - 直到不超过上限为止
        3. 重复 1. 2. 两步
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return insert(preorder, Integer.MAX_VALUE);
    }

    /*
        依次处理 preorder 中每个值，返回创建好的节点或 null
        1. 如果超过上限，返回 null 作为孩子返回
        2. 如果没超过上限，创建节点，并设置其左右孩子
            - 左右孩子完整后返回
     */
    int i = 0;
    public TreeNode insert(int[] preorder, int max) {
        if (i == preorder.length) {
            return null;
        }
        int val = preorder[i];
        if (val > max) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        i++;
        node.left = insert(preorder, val);
        node.right = insert(preorder, max);
        return node;
    }

}
