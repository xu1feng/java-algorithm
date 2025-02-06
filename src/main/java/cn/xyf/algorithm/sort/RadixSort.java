package cn.xyf.algorithm.sort;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 基数排序 最低有效数字LSD
 * @date 2025/2/6 14:14
 */

public class RadixSort {

    public static void sort(String[] a, int length) {
        // 1. 准备桶
        ArrayList<String>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        // 2. 进行多轮按位桶排序
        for (int i = length - 1; i >= 0; i--) {
            // 将字符放入合适的桶
            for (String s : a) {
                buckets[s.charAt(i) - '0'].add(s);
            }
            // 重新取出排好序的字符串，放回原始数组
            int k = 0;
            for (ArrayList<String> bucket : buckets) {
                for (String s : bucket) {
                    a[k++] = s;
                }
                bucket.clear();
            }
        }
    }

    public static void main(String[] args) {
        String[] phones = new String[10];
        phones[0] = "13812345678";
        phones[1] = "13912345678";
        phones[2] = "13612345678";
        phones[3] = "13712345678";
        phones[4] = "23512345678";
        phones[5] = "13412345678";
        phones[6] = "15012345678";
        phones[7] = "15112345678";
        phones[8] = "15212345678";
        phones[9] = "15712345678";

        sort(phones, 11);
        for (String phone : phones) {
            System.out.println(phone);
        }
    }

}
