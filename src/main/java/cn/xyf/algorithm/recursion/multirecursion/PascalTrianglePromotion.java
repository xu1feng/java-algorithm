package cn.xyf.algorithm.recursion.multirecursion;

/**
 * @author: Xuyifeng
 * @date: 2025/1/19 16:01
 * @description: 杨辉三角 - 优化
 */

public class PascalTrianglePromotion {

    public static void main(String[] args) {
        print2(5);
    }

    /**
     * <b>优化2 - 一维数组记忆法</b>
     */
    /*
        0  0  0  0  0  0  初始状态
        1  0  0  0  0  0   i=0
        1  1  0  0  0  0   i=1
        1  2  1  0  0  0   i=2
        1  3  3  1  0  0   i=3
        1  4  6  4  1  0   i=4
     */
    private static void createRow(int[] row, int i) {
        if (0 == i) {
            row[0] = 1;
            return;
        }
        for (int j = i; j > 0; j--) {
            row[j] = row[j] + row[j - 1];
        }
    }

    public static void print2(int n) {
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) { // 行
            createRow(cache, i);
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", cache[j]);
            }
            System.out.println();
        }
    }



    /**
     * <b>递归优化1 - 二维数组记忆法</b>
     *
     * @param i 行索引
     * @param j 列索引
     * @param cache 用来存储杨辉三角值的二维数组
     * @return 值
     */
    private static int element1(int i, int j, int[][] cache) {
        if (cache[i][j] > 0)
            return cache[i][j];

        if (0 == j || i == j) {
            cache[i][j] = 1;
            return 1;
        }

        cache[i][j] = element1(i - 1, j - 1, cache) + element1(i - 1, j, cache);
        return cache[i][j];
    }

    private static void printSpace(int n, int i) {
        int num = (n - 1 - i) * 2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    public static void print1(int n) {
        int[][] cache = new int[n][];
        for (int i = 0; i < n; i++) { // 行
            cache[i] = new int[i + 1]; // 第 i 行列的个数
            printSpace(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element1(i, j, cache));
            }
            System.out.println();
        }
    }

}
