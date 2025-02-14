package cn.xyf.algorithm.divideandconquer.leetcode;

/**
 * @author Xuyifeng
 * @description 快速幂 - 分治
 * @date 2025/2/14 14:48
 */

public class Leetcode50 {

    /*
                  2^10
              /         \
            2^5         2^5
           /  \        /  \
        2 2^2 2^2    2 2^2 2^2
         / \  / \     / \  / \
        2  2  2  2   2  2  2  2


                  256          n=1 x=65536 mul=1024
              /         \
            16          16          n=2 x=256 mul=4
           /  \        /  \
        2 4    4    2  4    4       n=5  x=16 mul=4
         / \  / \     / \  / \
        2  2  2  2   2  2  2  2     n=10  x=4  mul=1

     */

    static double myPowPositive(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double y = myPowPositive(x, n / 2);
        /*
            1   001 & 001 = 001
            2   010 & 001 = 000
            3   011 & 001 = 001
            4   100 & 001 = 000
         */
        if ((n & 1) == 0) { // 偶数
            return y * y;
        } else { // 奇数
            return x * y * y;
        }
    }

    public double myPow(double x, int n) {
        long p = n;
        if (p < 0) {
            p = -p;
        }
        double r = myPowPositive(x, p);
        return n < 0 ? 1 / r : r;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode50().myPow(2, 16));
        System.out.println(new Leetcode50().myPow(2, 0));
        System.out.println(new Leetcode50().myPow(2, -2));
        System.out.println(new Leetcode50().myPow(2, -2147483648));
        System.out.println(new Leetcode50().myPow(2.1, 3));
    }

}
