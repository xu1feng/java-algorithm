package cn.xyf.algorithm.recursion.singlerecursion;

/**
 * @author: Xuyifeng
 * @date: 2025/1/18 15:58
 * @description: 阶乘
 */

public class Factorial {

    public static int f(int n) {
        if (1 == n)
            return 1;
        return n * f(n - 1);
    }

    public static void main(String[] args) {
        int f = f(5);
        System.out.println(f);
    }

}
