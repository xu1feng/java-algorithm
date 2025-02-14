package cn.xyf.algorithm.divideandconquer.leetcode;

/**
 * @author Xuyifeng
 * @description 平方根整数部分
 * @date 2025/2/14 15:15
 */

public class Leetcode69 {

    /*
        99 = 9.?

        9 * 9 = 81
        10 * 10 = 100

        i   j   m
        1   99  50  6次
        1   49  25
        1   24  12
        1   11  6
        7   11  9
        10  11  10
     */

    public int mySqrt(int x) {
        int i = 1, j = x;
        int r = 0;
        while (i <= j) {
            int m = (i + j) >>> 1;
            int mm = m * m; // 防止越界
            if (m <= x / m) {
                i = m + 1;
                r = m;
            } else {
                j = m - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode69().mySqrt(1));
        System.out.println(new Leetcode69().mySqrt(2));
        System.out.println(new Leetcode69().mySqrt(4));
        System.out.println(new Leetcode69().mySqrt(8));
        System.out.println(new Leetcode69().mySqrt(9));
        System.out.println(new Leetcode69().mySqrt(99));
        System.out.println(new Leetcode69().mySqrt(2147395599));
    }

}
