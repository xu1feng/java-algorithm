package cn.xyf.代码随想录.二叉树.二叉树的统一迭代遍历;

import cn.xyf.代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/31 21:10
 */

public class postOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);      // 1. 初始时压入根节点

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek(); // 2. 查看栈顶元素（不立即弹出）

            if (node != null) {           // 3. 遇到普通节点时的处理
                stack.pop();               // 弹出当前节点（即上面的node）避免重复处理

                stack.push(node);          // 5. 重新压入当前节点
                stack.push(null);         // 6. 用null标记该节点已被访问

                // 注意压栈顺序与实际遍历顺序相反（栈的LIFO特性）
                if (node.right != null) {  // 4. 先压右子树（最后处理）
                    stack.push(node.right);
                }

                if (node.left != null) {   // 7. 最后压左子树（最先处理）
                    stack.push(node.left);
                }

            } else {                       // 8. 遇到标记null时的处理
                stack.pop();               // 弹出null标记
                node = stack.pop();        // 取出被标记的节点
                result.add(node.val);      // 9. 真正处理该节点
            }
        }
        return result;
    }
}
