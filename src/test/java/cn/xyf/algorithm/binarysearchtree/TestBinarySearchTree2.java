package cn.xyf.algorithm.binarysearchtree;

import org.junit.Test;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/1/26 09:42
 */

public class TestBinarySearchTree2 {

    public BinarySearchTree2<String, String> create() {
        BinarySearchTree2.Node<String, String> n1 = new BinarySearchTree2.Node<>("a", "张无忌");
        BinarySearchTree2.Node<String, String> n3 = new BinarySearchTree2.Node<>("c", "宋青书");
        BinarySearchTree2.Node<String, String> n2 = new BinarySearchTree2.Node<>("b", "周芷若", n1, n3);
        BinarySearchTree2.Node<String, String> n5 = new BinarySearchTree2.Node<>("e", "说不得");
        BinarySearchTree2.Node<String, String> n7 = new BinarySearchTree2.Node<>("g", "殷离");
        BinarySearchTree2.Node<String, String> n6 = new BinarySearchTree2.Node<>("f", "赵敏", n5, n7);
        BinarySearchTree2.Node<String, String> root = new BinarySearchTree2.Node<>("d", "小昭", n2, n6);

        BinarySearchTree2<String, String> tree = new BinarySearchTree2<>();
        tree.root = root;
        return tree;
    }

    @Test
    public void get1() {
        BinarySearchTree2<String, String> tree = create();
        System.out.println(tree.get1("a")); // 张无忌
        System.out.println(tree.get1("b")); // 周芷若
        System.out.println(tree.get1("c")); // 宋青书
        System.out.println(tree.get1("d")); // 小昭
        System.out.println(tree.get1("e")); // 说不得
        System.out.println(tree.get1("f")); // 赵敏
        System.out.println(tree.get1("g")); // 殷离
        System.out.println(tree.get1("h")); // null
    }

    @Test
    public void get2() {
        BinarySearchTree2<String, String> tree = create();
        System.out.println(tree.get2("a")); // 张无忌
        System.out.println(tree.get2("b")); // 周芷若
        System.out.println(tree.get2("c")); // 宋青书
        System.out.println(tree.get2("d")); // 小昭
        System.out.println(tree.get2("e")); // 说不得
        System.out.println(tree.get2("f")); // 赵敏
        System.out.println(tree.get2("g")); // 殷离
        System.out.println(tree.get2("h")); // null
    }
}