package cn.xyf.algorithm.rbl;

/**
 * @author Xuyifeng
 * @description 红黑树
 * @date 2025/1/28 09:55
 */

/**
 * <h3>红黑树</h3>
 */
public class RedBlackTree {

    enum Color {
        RED, BLACK;
    }

    private Node root;

    private static class Node {
        int key;
        Object value;
        Node left;
        Node right;
        Node parent;    // 父节点
        Color color = Color.RED;    // 颜色

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        // 是否是左孩子
        boolean isLeftChild() {
            return parent != null && parent.left == this; // 父节点不为空 且 父节点的左孩子与当前节点相同
        }

        // 叔叔
        Node uncle() {
            if (parent == null || parent.parent == null) { // 父节点为空 或 爷爷节点为空 则无叔叔
                return null;
            }
            if (parent.isLeftChild()) { // 父节点是爷爷的左孩子，则叔叔是爷爷的右孩子
                return parent.parent.right;
            } else {    // 父节点是爷爷的右孩子，则叔叔是爷爷的左孩子
                return parent.parent.left;
            }
        }

        // 兄弟
        Node sibling() {
            if (parent == null) {   // 父节点为空 则 无兄弟
                return null;
            }
            if (this.isLeftChild()) {   // 当前节点是父节点的左孩子 则 兄弟是父节点的右孩子
                return parent.right;
            } else {    // 当前节点是父节点的右孩子，则 兄弟是父节点的左孩子
                return parent.left;
            }
        }

    }

    // 判断红、黑
    boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    boolean isBlack(Node node) {
//        return node == null || node.color == Color.BLACK;
        return !isRed(node);
    }

    /*
        右旋
        1. parent 的处理
        2. 旋转后新根的父子关系在方法内建立
     */
    private void rightRotate(Node node) {
        Node parent = node.parent;
        Node child = node.left;
        Node grandChild = child.right;
        if (grandChild != null) {
            grandChild.parent = node;
        }
        child.right = node;
        child.parent = node.parent;
        node.left = grandChild;
        node.parent = child;
        if (parent == null) {
            root = child;
        } else if (parent.left == node) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    // 左旋
    private void leftRotate(Node pink) {
        Node parent = pink.parent;
        Node yellow = pink.right;
        Node green = yellow.left;
        if (green != null) {
            green.parent = pink;
        }
        yellow.left = pink;
        yellow.parent = parent;
        pink.right = green;
        pink.parent = yellow;
        if (parent == null) {
            root = yellow;
        } else if (parent.left == pink) {
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    /**
     * 新增或更新
     * 正常增、遇到红红不平衡进行调整
     * @param key 键
     * @param value 值
     */
    public void put(int key, Object value) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            parent = p;
            if (key < p.key) {
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            } else {
                p.value = value; // 更新
                return;
            }
        }
        Node inserted = new Node(key, value);
        if (parent == null) {
            root = inserted;
        } else if (key < parent.key) {
            parent.left = inserted;
            inserted.parent = parent;
        } else {
            parent.right = inserted;
            inserted.parent = parent;
        }
        fixRedRed(inserted);
    }

    void fixRedRed(Node x) {
        // case 1 插入节点是根节点，变黑即可
        if (x == root) {
            x.color = Color.BLACK;
            return;
        }
        // case 2 插入节点父亲是黑色，无需调整
        if (isBlack(x.parent)) {
            return;
        }
        /*
            case 3 当红红相邻，叔叔为红时
            需要将父亲、叔叔变黑，爷变红，然后对爷做递归处理
         */
        Node parent = x.parent;
        Node uncle = x.uncle();
        Node grandparent = parent.parent;
        if (isRed(uncle)) {
            parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grandparent.color = Color.RED;
            fixRedRed(grandparent);
            return;
        }

        /*
            case 4 插入节点的父亲为红色，触发红红相邻
            1. 父亲为左孩子，插入节点也是左孩子，此时即 LL 不平衡 -> 染色+旋转：父变黑，爷变红，父右旋，爷变父的右孩子
            2. 父亲为左孩子，插入节点是右孩子，此时即 LR 不平衡 -> 插入节点左旋再变黑，爷节点变红，插入节点右旋，爷变父的右孩子
            3. 父亲为右孩子，插入节点也是右孩子，此时即 RR 不平衡
            4. 父亲为右孩子，插入节点是左孩子，此时即 RL 不平衡
         */

        if (parent.isLeftChild() && x.isLeftChild()) { // case 4-1 LL
            parent.color = Color.BLACK;
            grandparent.color = Color.RED;
            rightRotate(grandparent);
        } else if (parent.isLeftChild() && !x.isLeftChild()) { // case 4-2 LR
            leftRotate(parent);
            x.color = Color.BLACK;
            grandparent.color = Color.RED;
            rightRotate(grandparent);
        } else if (!parent.isLeftChild() && !x.isLeftChild()) { // case 4-3 RR
            parent.color = Color.BLACK;
            grandparent.color = Color.RED;
            leftRotate(grandparent);
        } else { // case 4-4 RL
            rightRotate(parent);
            x.color = Color.BLACK;
            grandparent.color = Color.RED;
            leftRotate(grandparent);
        }
    }

    /**
     * 删除
     * 正常删、会用到李代桃僵技巧、遇到黑黑不平衡进行调整
     * @param key
     */
    public void remove(int key) {
        Node deleted = find(key);
        if (deleted == null) {
            return;
        }
        doRemove(deleted);
    }

    /*
        处理双黑：删除节点和剩下节点都是黑，触发双黑，双黑意思是，少了一个黑
        case 3：删除节点或剩余节点的兄弟为红，此时两个侄子定为黑
        case 4：删除节点或剩余节点的兄弟、和兄弟孩子都为黑
            - 将兄弟变红，目的是将删除节点和兄弟那边的黑色高度同时减少1
            - 如果父亲是红，则需将父亲变为黑，避免红红，此时路径黑节点数目不变
            - 如果父亲是黑，说明这条路径还是少黑，再次让父节点触发双黑
        case 5：删除节点的兄弟为黑，至少一个红侄子
            - 如果兄弟是左孩子，左侄子是红，LL 不平衡
            - 如果兄弟是左孩子，右侄子是红，LR 不平衡
            - 如果兄弟是右孩子，右侄子是红，RR 不平衡
            - 如果兄弟是右孩子，左侄子是红，RL 不平衡
     */
    private void fixDoubleBlack(Node x) {
        if (x == root) {
            return;
        }
        Node parent = x.parent;
        Node sibling = x.sibling();
        // case 3 兄弟节点是红色
        if (isRed(sibling)) {
            if (x.isLeftChild()) {
                leftRotate(parent);
            } else {
                rightRotate(parent);
            }
            parent.color = Color.RED;
            sibling.color = Color.BLACK;
            fixDoubleBlack(x);
            return;
        }
        if (sibling != null) {
            // case 4 兄弟是黑色，两个侄子也是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                sibling.color = Color.RED;
                if (isRed(parent)) {
                    parent.color = Color.BLACK;
                } else {
                    fixDoubleBlack(parent);
                }
            } else {
                // case 5 兄弟是黑色 侄子有红色
                if (sibling.isLeftChild() && isRed(sibling.left)) {
                    rightRotate(parent);
                    sibling.left.color = Color.RED;
                    sibling.color = parent.color;

                }
                // LR
                else if (sibling.isLeftChild() && isRed(sibling.right)) {
                    sibling.right.color = parent.color;
                    leftRotate(sibling);
                    rightRotate(parent);
                }
                // RL
                else if (!sibling.isLeftChild() && isRed(sibling.left)) {
                    sibling.left.color = parent.color;
                    rightRotate(sibling);
                    leftRotate(parent);
                }
                // RR
                else {
                    leftRotate(parent);
                    sibling.right.color = Color.BLACK;
                    sibling.color = parent.color;
                }
                parent.color = Color.BLACK;
            }
        } else {
            fixDoubleBlack(parent);
        }
    }

    private void doRemove(Node deleted) {
        Node replaced = findReplaced(deleted);
        Node parent = deleted.parent;
        // 没有孩子
        if (replaced == null) {
            /*
                case 1：删的是根节点
                    - 删完了，直接将 root = null
             */
            if (deleted == root) {
                root = null;
            } else {
                if (isBlack(deleted)) {
                    // 复杂调整
                    fixDoubleBlack(deleted);
                } else {
                    // 红色叶子，无需任何处理
                }
                // 删除的不是根节点 且没有孩子
                if (deleted.isLeftChild()) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                deleted.parent = null; // help GC
            }
            return;
        }
        // 有一个孩子
        if (deleted.left == null || deleted.right == null) {
            /*
                case 1：删的是根节点
                    - 用剩余节点替换了根节点的 key, value，根节点孩子 = null，颜色保持黑色不变
             */
            if (deleted == root) {
                root.key = replaced.key;
                root.value = replaced.value;
                root.left = null;
                root.right = null;
            } else {
                if (deleted.isLeftChild()) {
                    parent.left = replaced;
                } else {
                    parent.right = replaced;
                }
                replaced.parent = parent;
                deleted.left = deleted.right = deleted.parent = null;
                if (isBlack(deleted) && isBlack(replaced)) {
                    // 复杂处理
                    fixDoubleBlack(replaced);
                } else {
                    // case 2 删的是黑，剩下是红，剩下这个红节点变黑
                    replaced.color = Color.BLACK;
                }
            }
            return;
        }
        // 有两个孩子 -> 有一个孩子 或 没有孩子
        int t = deleted.key;
        deleted.key = replaced.key;
        replaced.key = t;
        Object val = deleted.value;
        deleted.value = replaced.value;
        replaced.value = val;
        doRemove(replaced);

    }

    // 查找删除节点
    private Node find(int key) {
        Node p = root;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    // 查找剩余节点
    private Node findReplaced(Node deleted) {
        if (deleted.left == null && deleted.right == null) {
            return null;
        }
        if (deleted.left == null) {
            return deleted.right;
        }
        if (deleted.right == null) {
            return deleted.left;
        }
        Node s = deleted.right;
        while (s.left != null) {
            s = s.left;
        }
        return s;
    }

}
