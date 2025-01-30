package cn.xyf.algorithm.binarysearchtree;

/**
 * @author Xuyifeng
 * @description 二叉搜索树 - 泛型 key 版本
 * @date 2025/1/26 09:28
 */

public class BinarySearchTree2<K extends Comparable<K>, V> { // 泛型 T 必须是 Comparable 的子类类型

    Node<K, V> root;

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;

        public Node(K key) {
            this.key = key;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private V doGet(Node<K, V> node, K key) {
        if (node == null) {
            return null; // 没找到
        }
        int result = key.compareTo(node.key);
        if (result < 0) {
            return doGet(node.left, key); // 向左找
        } else if (result > 0) {
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
    public Object get1(K key) {
        return doGet(root, key);
    }

    /**
     * 查询关键字对应的值 - 非递归
     *
     * @param key 关键字
     * @return 关键字对应的值
     */
    public Object get2(K key) {
        Node<K, V> node = root;
        while (node != null) {
            // node.key VS key
            /*
                -1 key < node.key
                0 key == node.key
                1 key > node.key
             */
            int result = key.compareTo(node.key);
            if (result < 0) {
                node = node.left;
            } else if (result > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }
    
}
