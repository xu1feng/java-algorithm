package cn.xyf.algorithm.greedy.leetcode;

/**
 * @author Xuyifeng
 * @description 零钱兑换 - 贪心解法：可能得到错误的解
 * @date 2025/2/10 14:24
 */

public class Leetcode322_greedy {

    /*
        贪心原则：
            1. 每次都选取当前最优解
            2. 《向前看，别回头》
    */
    public int coinChange(int[] coins, int amount) {
        // 每次循环都找到当前最优解：面值最大的硬币，它凑出的硬币数最少
        int remainder = amount;
        int count = 0;
        for (int coin : coins) {
            // 假定已降序排列
            while (remainder > coin) {
                remainder -= coin;
                count++;
            }
            if (remainder == coin) {
                remainder = 0;
                count++;
                break;
            }
        }
        if (remainder > 0) {
            return -1;
        } else {
            return count;
        }
    }

    public static void main(String[] args) {
        Leetcode322_greedy leetcode = new Leetcode322_greedy();
        int count = leetcode.coinChange(new int[]{5, 2, 1}, 5);
//        int count = leetcode.coinChange(new int[]{25, 10, 5, 1}, 41);
//        int count = leetcode.coinChange(new int[]{2}, 3);

        // 问题1 没有回头，导致找到更差的解
//        int count = leetcode.coinChange(new int[]{15, 10, 1}, 21);
        // 问题2 没有回头，导致无解
//        int count = leetcode.coinChange(new int[]{15, 10}, 20);
        System.out.println(count);
    }
}
