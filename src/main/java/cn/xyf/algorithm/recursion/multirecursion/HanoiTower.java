package cn.xyf.algorithm.recursion.multirecursion;

import java.util.LinkedList;

/**
 * @author: Xuyifeng
 * @date: 2025/1/19 15:05
 * @description: 汉诺塔
 */

public class HanoiTower {

    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    // 3 2 1

    /**
     * 初始化
     *
     * @param n 柱子上的圆盘个数
     */
    static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }

    /**
     * @param n 圆盘个数
     * @param a 源
     * @param b 借
     * @param c 目标
     */
    static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if (n == 0) {
            return;
        }
        move(n - 1, a, c, b);
        c.addLast(a.removeLast()); // 中间
        print();
        move(n - 1, b, a, c);
    }

    public static void main(String[] args) {
        init(3);
        print();
        move(3, a, b, c);
    }

    private static void print() {
        System.out.println("---------------------------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
