package cn.xyf.algorithm.recursion.singlerecursion;

/**
 * @author: Xuyifeng
 * @date: 2025/1/18 16:05
 * @description: 递归反向打印字符串
 */

public class ReversePrintString {

    public static void f(int n, String str) {
        if (n == str.length())
            return;
        f(n + 1, str);
        System.out.println(str.charAt(n));
    }

    public static void main(String[] args) {
        f(0, "abcd");
    }

}
