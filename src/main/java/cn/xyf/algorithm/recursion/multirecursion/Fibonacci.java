package cn.xyf.algorithm.recursion.multirecursion;

/**
 * @author: Xuyifeng
 * @date: 2025/1/19 11:13
 * @description: 递归求斐波那契数列
 */

public class Fibonacci {

    public static int f(int n) {
        if (0 == n) {
            return 0;
        } else if (1 == n) {
            return 1;
        }

        int x = f(n - 1);
        int y = f(n - 2);
        return x + y;
    }

    public static void main(String[] args) {
        int f = f(8);
        System.out.println(f);
    }

}
