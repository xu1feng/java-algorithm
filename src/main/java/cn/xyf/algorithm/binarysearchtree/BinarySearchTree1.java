package cn.xyf.algorithm.binarysearchtree;

import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description 二叉搜索树
 * @date 2025/1/26 09:28
 */

public class BinarySearchTree1 {

    Node root;

    static class Node {
        int key;
        Object value;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key, Object value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private Object doGet(Node node, int key) {
        if (node == null) {
            return null; // 没找到
        }
        if (key < node.key) {
            return doGet(node.left, key); // 向左找
        } else if (key > node.key) {
            return doGet(node.right, key); // 向右找
        } else {
            return node.value; // 找到了
        }
    }

    /**
     * 查询关键字对应的值 - 递归
     *
     * @param key 关键字
     * @return 关键字对应的值
     */
    public Object get1(int key) {
        return doGet(root, key);
    }

    /**
     * 查询关键字对应的值 - 非递归
     *
     * @param key 关键字
     * @return 关键字对应的值
     */
    public Object get2(int key) {
        Node node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    private Object doMin(Node node) {
        if (node == null) { // 树为空
            return null;
        }
        if (node.left == null) { // 最小的节点
            return node.value;
        }
        return doMin(node.left);
    }

    /**
     * 查找最小关键字对应值 - 递归
     * @return 关键字对应值
     */
    public Object min1() {
        return doMin(root);
    }

    /**
     * 查找最小关键字对应值 - 非递归
     * @return 关键字对应值
     */
    public Object min2() {
        return min(root);
    }

    private Object min(Node node) {
        if (node == null) {
            return null;
        }
        Node p = node;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }

    private Object doMax(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node.value;
        }
        return doMax(node.right);
    }

    /**
     * 查找最大关键字对应值 - 递归
     * @return 关键字对应值
     */
    public Object max1() {
        return doMax(root);
    }

    /**
     * 查找最大关键字对应值 - 非递归
     * @return 关键字对应值
     */
    public Object max2() {
        return max(root);
    }

    private Object max(Node node) {
        if (node == null) {
            return null;
        }
        Node p = node;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }

    /**
     * 存储关键字和对应值 - 非递归
     * @param key 关键字
     * @param value 值
     */
    public void put(int key, Object value) {
        Node node = root;
        Node parent = null; // 父节点
        while (node != null) {
            parent = node;
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                // // 1. key 有 -> 更新
                node.value = value;
                return;
            }
        }
        if (parent == null) { // 树为空
            root = new Node(key, value);
            return;
        }
        // 2. key 没有 -> 新增
        if (key < parent.key) {
            parent.left = new Node(key, value);
        } else {
            parent.right = new Node(key, value);
        }
    }

    /**
     * 查找关键字的前驱值
     * @param key 关键字
     * @return 前驱值
     */
    public Object predecessor(int key) {
        Node p = root;
        Node ancestorFromLeft = null;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (p.key < key) {
                ancestorFromLeft = p;
                p = p.right;
            } else {
                break;
            }
        }

        // 没找到节点
        if (p == null) {
            return null;
        }
        /*
            情况1：节点有左子树，此时前驱就是左子树的最大值
            情况2：节点没有左子树，若离他最近的、自左而来的祖先就是前任
         */
        if (p.left != null) {
            return max(p.left);
        }
        return ancestorFromLeft != null ? ancestorFromLeft.value : null;
    }

    /**
     * 查找关键字的后继值
     * @param key 关键字
     * @return 后继值
     */
    public Object successor(int key) {
        Node p = root;
        Node ancestorFromRight = null;
        while (p != null) {
            if (key < p.key) {
                ancestorFromRight = p;
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            } else {
                break;
            }
        }

        // 没找到节点
        if (p == null) {
            return null;
        }
        /*
            情况1：节点有右子树，此时后继就是右子树的最小值
            情况2：节点没有右子树，若离他最近的、自右而来的祖先就是后继
         */
        if (p.right != null) {
            return min(p.right);
        }
        return ancestorFromRight != null ? ancestorFromRight.value : null;
    }

    /**
     * 托孤方法
     * @param parent 被删除节点的父亲
     * @param deleted 被删除节点
     * @param child 被顶上去的节点
     */
    private void shift(Node parent, Node deleted, Node child) {
        if (parent == null) { // 被删除的是根节点
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else if (deleted == parent.right) {
            parent.right = child;
        }
    }

    /**
     * 根据关键字删除 - 非递归
     * @param key 关键字
     * @return 被删除关键字对应值
     */
    public Object delete1(int key) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (key < p.key) {
                parent = p;
                p = p.left;
            } else if (key > p.key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        // 删除操作
        /*
            情况1：删除节点没有左孩子，将右孩子托孤给 parent
            情况2：删除节点没有右孩子，将左孩子托孤给 parent
            情况3：删除节点左右孩子都没有，已经被涵盖在情况1、情况2当中，把null托孤给parent
            情况4：删除节点左右孩子都有
                可以将它的后继节点（S）托孤给parent，S的父亲为SP
                - SP就是被删除节点，此时被删除节点与S紧邻，只需将S托孤给 parent
                - SP不是被删除节点，此时被删除节点与S不紧邻，此时需要将S的后代托孤给SP，再将S托孤给 parent
         */
        if (p.left == null) {
            // 情况1
            shift(parent, p, p.right);
        } else if (p.right == null) {
            // 情况2
            shift(parent, p, p.left);
        } else {
            // 情况4
            Node s = p.right;
            Node sParent = p; // 后继节点父亲
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            // s 为后继节点
            if (sParent != p) { // 不相邻
                // 删除节点和后继节点不相邻，处理后继节点的后事
                shift(sParent, s, s.right); // 不可能有左孩子 因为后继节点是右子树最左下节点
                s.right = p.right;
            }
            // 后继节点取代被删除节点
            shift(parent, p, s);
            s.left = p.left;
        }
        return p.value;
    }

    /**
     *
     * @param node 起点
     * @param key
     * @return 删剩下的孩子（找到） 或 null（没找到）
     */
    private Node doDelete(Node node, int key, ArrayList<Object> result) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = doDelete(node.left, key, result);
            return node;
        }
        result.add(node.value);
        if (node.key < key) {
            node.right = doDelete(node.right, key, result);
            return node;
        }
        // 情况1：只有右孩子
        if (node.left == null) {
            return node.right;
        }
        // 情况2：只有左孩子
        if (node.right == null) {
            return node.left;
        }
        // 情况3：有两个孩子
        Node s = node.right;
        while (s.left != null) {
            s = s.left;
        }
        s.right = doDelete(node.right, s.key, new ArrayList<>());
        s.left = node.left;
        return s;
    }

    public Object delete(int key) {
        ArrayList<Object> result = new ArrayList<>(); // 保存被删除节点的值
        root = doDelete(root, key, result);
        return result.isEmpty() ? null : result.get(0);
    }

    /*
        二叉搜索树 -> 中序遍历是升序结果
     */

    // 找 < key 的所有 value
    public List<Object> less(int key) {
        ArrayList<Object> result = new ArrayList<>();
        Node p = root;
        LinkedList<Node> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                Node pop = stack.pop();
                // 处理值
                if (pop.key < key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

    // 找 > key 的所有 value - 中序遍历
    public List<Object> greater1(int key) {
        ArrayList<Object> result = new ArrayList<>();
        Node p = root;
        LinkedList<Node> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                Node pop = stack.pop();
                // 处理值
                if (pop.key > key) {
                    result.add(pop.value);
                }
                p = pop.right;
            }
        }
        return result;
    }

    // 找 > key 的所有 value - 反向中序遍历
    public List<Object> greater2(int key) {
        ArrayList<Object> result = new ArrayList<>();
        Node p = root;
        LinkedList<Node> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.right;
            } else {
                Node pop = stack.pop();
                // 处理值
                if (pop.key > key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.left;
            }
        }
        return result;
    }

    //找 >= key1 且 <= key2 的所有值
    public List<Object> between(int key1, int key2) {
        ArrayList<Object> result = new ArrayList<>();
        Node p = root;
        LinkedList<Node> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                Node pop = stack.pop();
                // 处理值
                if (pop.key >= key1 && pop.key <= key2) {
                    result.add(pop.value);
                } else if (pop.key > key2) {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

}
