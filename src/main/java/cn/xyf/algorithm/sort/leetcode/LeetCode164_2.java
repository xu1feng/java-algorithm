package cn.xyf.algorithm.sort.leetcode;

import cn.xyf.algorithm.sort.InsertionSort;
import cn.xyf.datastruct.array.DynamicArray;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

/**
 * @author Xuyifeng
 * @description 最大间距
 * @date 2025/2/6 20:50
 */

public class LeetCode164_2 {

    public int maximumGap(int[] a) {
        if (a.length < 2) {
            return 0;
        }

        // 计算最大值
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(a[i], max);
        }

        // 准备10个桶
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 没超过最大值
        long exp = 1;
        while (max >= exp) {
            for (int j : a) {
                buckets[(j / (int) exp) % 10].add(j);
            }
            int k = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (Integer i : bucket) {
                    a[k++] = i;
                }
                bucket.clear();
            }
            exp *= 10;
        }

        // 求最大间距
        int r = 0;
        for (int i = 1; i < a.length; i++) {
            r = Math.max(r, a[i] - a[i - 1]);
        }
        return r;
    }

}
