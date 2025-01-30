package cn.xyf.algorithm.binarysearchtree;

import org.junit.Test;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/1/26 09:42
 */

public class TestBinarySearchTree1 {

    public BinarySearchTree1 create() {
        BinarySearchTree1.Node n1 = new BinarySearchTree1.Node(1, "张无忌");
        BinarySearchTree1.Node n3 = new BinarySearchTree1.Node(3, "宋青书");
        BinarySearchTree1.Node n2 = new BinarySearchTree1.Node(2, "周芷若", n1, n3);
        BinarySearchTree1.Node n5 = new BinarySearchTree1.Node(5, "说不得");
        BinarySearchTree1.Node n7 = new BinarySearchTree1.Node(7, "殷离");
        BinarySearchTree1.Node n6 = new BinarySearchTree1.Node(6, "赵敏", n5, n7);
        BinarySearchTree1.Node root = new BinarySearchTree1.Node(4, "小昭", n2, n6);

        BinarySearchTree1 tree = new BinarySearchTree1();
        tree.root = root;
        return tree;
    }

    @Test
    public void get() {
        BinarySearchTree1 tree = create();
        System.out.println(tree.get1(1));
        System.out.println(tree.get1(2));
        System.out.println(tree.get1(3));
        System.out.println(tree.get1(4));
        System.out.println(tree.get1(5));
        System.out.println(tree.get1(6));
        System.out.println(tree.get1(7));
        System.out.println(tree.get1(8));
        System.out.println(tree.get2(1));
        System.out.println(tree.get2(2));
        System.out.println(tree.get2(3));
        System.out.println(tree.get2(4));
        System.out.println(tree.get2(5));
        System.out.println(tree.get2(6));
        System.out.println(tree.get2(7));
        System.out.println(tree.get2(8));
    }

    @Test
    public void min() {
        BinarySearchTree1 tree = create();
        System.out.println(tree.min1());
        System.out.println(tree.min2());
    }

    @Test
    public void max() {
        BinarySearchTree1 tree = create();
        System.out.println(tree.max1());
        System.out.println(tree.max2());
    }

    @Test
    public void put() {
        BinarySearchTree1 tree = create();
        tree.put(8, "彭天舒");
        System.out.println(tree.get1(8));
        tree.put(1, "徐一峰");
        System.out.println(tree.get1(1));
    }

}
