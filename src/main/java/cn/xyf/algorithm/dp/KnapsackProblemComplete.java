package cn.xyf.algorithm.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Xuyifeng
 * @description 完全背包问题 - 动态规划
 * @date 2025/2/11 14:22
 */

public class KnapsackProblemComplete {

    static class Item {
        int index;
        String name;
        int weight;
        int value;

        public Item(int index, String name, int weight, int value) {
            this.index = index;
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item(" + name + ")";
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(1, "青铜", 2, 3),    // c
                new Item(2, "白银", 3, 4),    // s
                new Item(3, "黄金", 4, 7),    // a
        };
        System.out.println(select(items, 6));
    }

    /*
            0   1   2   3   4   5   6
        1   0   0   c   c   cc  cc  ccc
        2   0   0   c   s   cc  cs  ccc
        3   0   0   c   s   a   a   ac
     */

    private static int select(Item[] items, int total) {
        int[][] dp = new int[items.length][total + 1];
        Item item0 = items[0];
        for (int j = 0; j < total + 1; j++) {
            if (j >= item0.weight) {
                dp[0][j] = dp[0][j - item0.weight] + item0.value;
            }
        }
        print(dp);
        for (int i = 1; i < items.length; i++) {
            Item item = items[i];
            for (int j = 0; j < total + 1; j++) {
                int x = dp[i - 1][j]; // 上次的最大值
                if (j >= item.weight) {
                    //                               剩余空间能装的最大价值 + 当前物品价值
                    dp[i][j] = Integer.max(x, dp[i][j - item.weight] + item.value);
                } else {
                    dp[i][j] = x;
                }
            }
        }
        print(dp);
        return dp[items.length - 1][total];
    }

    // 优化 - 降维
    private static int select2(Item[] items, int total) {
        int[] dp = new int[total + 1];
        for (Item item : items) {
            for (int j = 0; j < total + 1; j++) {
                if (j >= item.weight) {
                    dp[j] = Integer.max(dp[j], dp[j - item.weight] + item.value);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[total];
    }

    static void print(int[][] dp) {
        System.out.println("   " + "-".repeat(63));
        Object[] array = IntStream.range(0, dp[0].length + 1).boxed().toArray();
        System.out.printf(("%5d ".repeat(dp[0].length)) + "%n", array);
        for (int[] d : dp) {
            array = Arrays.stream(d).boxed().toArray();
            System.out.printf(("%5d ".repeat(d.length)) + "%n", array);
        }
    }

}
