package cn.xyf.algorithm.recursion.multirecursion;

/**
 * @author: Xuyifeng
 * @date: 2025/1/19 15:25
 * @description: 杨辉三角
 */

public class PascalTriangle {

    /**
     * <b>直接递归（未优化）</b>
     *
     * @param i 行索引
     * @param j 列索引
     * @return 值
     */
    private static int element(int i, int j) {
        if (0 == j || i == j)
            return 1;
        return element(i - 1, j - 1) + element(i - 1, j);
    }

    /**
     * 打印空格
     * @param n 高度
     * @param i 行索引
     */
    private static void printSpace(int n, int i) {
        int num = (n - 1 - i) * 2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    /**
     * 打印杨辉三角
     * @param n 杨辉三角的高度
     */
    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element(i, j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(6);
    }

}
