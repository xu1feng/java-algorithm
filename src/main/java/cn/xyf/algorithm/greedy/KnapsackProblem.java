package cn.xyf.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Xuyifeng
 * @description 0-1 背包问题
 * @date 2025/2/10 17:12
 */

/**
 * <h3>0-1 背包问题 - 贪心解法</h3>
 * 注意：可能无法达到最优解
 */
public class KnapsackProblem {

    /*
    1. n个物品都是固体，有重量和价值
    2. 现在你要取走不超过 10克 的物品
    3. 每次可以不拿或全拿，问最高价值是多少

        编号 重量(g)  价值(元)
        0   1       1_000_000      钻戒一枚
        1   4       1600           黄金一块
        2   8       2400           红宝石戒指一枚
        3   5       30             白银一块

     */

    static class Item {
        int index;
        int weight;
        int value;

        public Item(int index, int weight, int value) {
            this.index = index;
            this.weight = weight;
            this.value = value;
        }

        public int unitValue() {
            return value / weight;
        }

        @Override
        public String toString() {
            return "Item(" + index + ")";
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(0, 1, 1_000_000),
                new Item(1, 4, 1600),
                new Item(2, 8, 2400),
                new Item(3, 5, 30)
        };
        select(items, 10);
    }

    static void select(Item[] items, int total) {
        Arrays.sort(items, Comparator.comparingInt(Item::unitValue).reversed());
        int max = 0; // 最大价值
        for (Item item : items) {
            System.out.println(item);
            if (total >= item.weight) { // 可以拿完
                total -= item.weight;
                max += item.value;
            }
        }
        System.out.println("最大价值是:" + max); // 实际上应该是1002400
    }

}
