package cn.xyf.algorithm.btree;

import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description B 树
 * @date 2025/1/30 16:55
 */

public class BTree {

    static class Node {
        int[] keys; // 节点中的关键字
        Node[] children; // 孩子
        int keyNumber; // 有效关键字的个数
        boolean isLeaf = true; // 是否是叶子节点
        int degree; // 最小度数 (最小孩子数)

        public Node(int degree) { // t >= 2
            this.degree = degree;
            this.children = new Node[2 * degree];
            this.keys = new int[2 * degree - 1];
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }

        // 多路查找
        Node get(int key) {
            int i = 0;
            while (i < keyNumber) {
                if (keys[i] == key) {
                    return this;
                }
                if (keys[i] > key) {
                    break;
                }
                i++;
            }
            // 执行到此时 keys[i]>key 或 i==keyNumber
            if (isLeaf) {
                return null;
            }
            // 非叶子情况
            return children[i].get(key);
        }

        // 向指定索引处插入 key
        void insertKey(int key, int index) {
            // 将index及其后面的key向后移动一位
            System.arraycopy(keys, index, keys, index + 1, keyNumber - index);
            // 插入新key
            keys[index] = key;
            // 有效key数量增加
            keyNumber++;
        }

        // 向指定索引处插入 child
        void insertChild(Node child, int index) {
            // 将index及其后面的child向后移动一位
            System.arraycopy(children, index, children, index + 1, keyNumber - index);
            // 插入新child
            children[index] = child;
        }

        // 移除指定 index 处的 key
        int removeKey(int index) {
            int t = keys[index];
            System.arraycopy(keys, index + 1, keys, index, --keyNumber - index);
            return t;
        }

        // 移除最左边的 key
        int removeLeftMostKey() {
            return removeKey(0);
        }

        // 移除最右边的 key
        int removeRightMostKey() {
            return removeKey(keyNumber - 1);
        }

        // 移除指定 index 处的 child
        Node removeChild(int index) {
            Node t = children[index];
            System.arraycopy(children, index + 1, children, index, keyNumber - index);
            children[keyNumber] = null;
            return t;
        }

        // 移除最左边的 child
        Node removeLeftmostChild() {
            return removeChild(0);
        }

        // 移除最右边的 child
        Node removeRightmostChild() {
            return removeChild(keyNumber);
        }

        // index 孩子处左边的兄弟
        Node childLeftSibling(int index) {
            return index > 0 ? children[index - 1] : null;
        }

        // index 孩子处右边的兄弟
        Node childRightSibling(int index) {
            return index == keyNumber ? null : children[index + 1];
        }

        // 复制当前节点的所有 key 和 child 到 target
        void moveToTarget(Node target) {
            int start = target.keyNumber;
            if (!isLeaf) {
                for (int i = 0; i <= keyNumber; i++) {
                    target.children[start + i] = children[i];
                }
            }
            for (int i = 0; i < keyNumber; i++) {
                target.keys[target.keyNumber++] = keys[i];
            }
        }

    }

    Node root;

    int degree; // 树中节点最小度数
    final int MIN_KEY_NUMBER; // 最小 key 的数目
    final int MAX_KEY_NUMBER; // 最大 key 的数目

    public BTree() {
        this(2);
    }

    public BTree(int degree) {
        this.degree = degree;
        root = new Node(degree);
        MAX_KEY_NUMBER = 2 * degree - 1;
        MIN_KEY_NUMBER = degree - 1;
    }

    // 1. 是否存在
    public boolean contains(int key) {
        return root.get(key) != null;
    }

    // 2. 新增
    /*
        首先查找本节点中的插入位置i，如果没有空位（key被找到），应该走更新的逻辑，目前什么没做
        接下来分两种情况：
            - 如果节点是叶子节点，可以直接插入了
            - 如果节点是非叶子节点，需要继续在children[i]处继续递归插入
        无论哪种情况，插入完成后都可能超过节点keys数目限制，此时应当执行节点分裂
     */
    public void put(int key) {
        doPut(root, key, null, 0);
    }

    private void doPut(Node node, int key, Node parent, int index) {
        int i = 0;
        while (i < node.keyNumber) {
            if (node.keys[i] == key) {
                return; // 更新逻辑
            }
            if (node.keys[i] > key) {
                break; // 找到插入位置，即为 i
            }
            i++;
        }
        if (node.isLeaf) {
            node.insertKey(key, i);
            // 上限

        } else {
            doPut(node.children[i], key, node, i);
            // 上限
        }
        if (node.keyNumber == MAX_KEY_NUMBER) {
            split(node, parent, index);
        }
    }

    // 分裂
    /*
        1. 创建 right 节点（分裂后大于当前 left 节点的），把 t 以后的 key 和 child 都拷贝过去
        2. t - 1处的 key 插入到 parent 的 index 处，index 指 left 作为孩子时的索引
        3. right 节点作为 parent 的孩子插入到 index + 1处
     */
    private void split(Node left, Node parent, int index) {
        if (parent == null) { // 分裂的是根节点
            Node newRoot = new Node(degree);
            newRoot.isLeaf = false;
            newRoot.insertChild(left, 0);
            this.root = newRoot;
            parent = newRoot;
        }
        Node right = new Node(degree);
        right.isLeaf = left.isLeaf;
        System.arraycopy(left.keys, degree, right.keys, 0, degree - 1);
        if (!left.isLeaf) {
            System.arraycopy(left.children, degree, right.children, 0, degree - 1);
        }
        right.keyNumber = degree - 1;
        left.keyNumber = degree - 1;
        int mid = left.keys[degree - 1];
        parent.insertKey(mid, index);
        parent.insertChild(right, index + 1);
    }

    // 3. 删除
    /*
        case 1：当前节点是叶子节点，没找到
            - 返回
        case 2：当前节点是叶子节点，找到了
            - 直接删
        case 3：当前节点是非叶子节点，没找到
        case 4：当前节点是非叶子节点，找到了
            - 用后继 key 替换 被删除的 key
            - 删除后继 key
        case 5；删除后 key < 下限（不平衡）
        case 6：根节点
     */
    public void remove(int key) {
        doRemove(root, null, key, 0);
    }

    private void doRemove(Node node,Node parent, int key, int index) {
        int i = 0;
        while (i < node.keyNumber) {
            if (node.keys[i] >= key) {
                break;
            }
            i++;
        }
        // i 找到：代表待删除 key 的索引
        // i 没找到：代表到第 i 个孩子继续查找
        if (node.isLeaf) {
            if (!found(node, key, i)) { // case 1
                return;
            } else { // case 2
                node.removeKey(i);
            }
        } else {
            if (!found(node, key, i)) { // case 3
                doRemove(node.children[i], node, key, i);
            } else { // case 4
                Node s = node.children[i + 1];
                while (!s.isLeaf) {
                    s = s.children[0];
                }
                int suffixKey = s.keys[0]; // 后继 key
                node.keys[i] = suffixKey; // 替换待删除的 key
                doRemove(node.children[i + 1], node, suffixKey, i + 1); // 删除后继 key
            }
        }
        if (node.keyNumber < MIN_KEY_NUMBER) {
            // 调整平衡 case 5、case 6
            balance(parent, node, index);
        }
    }

    private void balance(Node node, Node parent, int index) {
        // case 6 根节点
        if (node == root) {
            if (root.keyNumber == 0 && root.children[0] != null) {
                root = root.children[0];
            }
            return;
        }
        Node leftSibling = parent.childLeftSibling(index);
        Node rightSibling = parent.childRightSibling(index);
        if (leftSibling != null && leftSibling.keyNumber > MIN_KEY_NUMBER) {
            // case 5-1 左边富裕，右旋（找左借）
            // 1. 父节点中前驱 key 旋转下来
            node.insertKey(parent.keys[index - 1], 0);
            if (!leftSibling.isLeaf) {
                // 2. left 中最大的孩子换爹
                node.insertChild(leftSibling.removeRightmostChild(), 0);
            }
            // 3. left 中最大的 key 旋转上去
            parent.keys[index - 1] = leftSibling.removeRightMostKey();
            return;
        }
        if (rightSibling != null && rightSibling.keyNumber > MIN_KEY_NUMBER) {
            // case 5-2 右边富裕，左旋（找右借）
            // 1. 从父节点中将当前节点的后继key旋转下来
            node.insertKey(parent.keys[index], node.keyNumber);
            if (!rightSibling.isLeaf) {
                // 2. right 中最小的孩子换爹
                node.insertChild(rightSibling.removeLeftmostChild(), node.keyNumber + 1);
            }
            // 3. right 中最小的key旋转上去
            parent.keys[index] = rightSibling.removeLeftMostKey();
        }
        // case 5-3 两边都不富裕，向左合并
        if (leftSibling != null) {
            // 向左兄弟合并
            parent.removeChild(index);
            leftSibling.insertKey(parent.removeKey(index - 1), leftSibling.keyNumber);
            node.moveToTarget(leftSibling);
        } else {
            // 向自己合并
            parent.removeChild(index + 1);
            node.insertKey(parent.removeKey(index), node.keyNumber);
            rightSibling.moveToTarget(node);
        }

    }

    private static boolean found(Node node, int key, int i) {
        return i < node.keyNumber && node.keys[i] == key;
    }

}
