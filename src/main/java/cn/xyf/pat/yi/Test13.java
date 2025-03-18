package cn.xyf.pat.yi;

import java.util.*;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/9 15:35
 */

public class Test13 {
    private static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int m = myScanner.nextInt(); // 第M个素数
        int n = myScanner.nextInt(); // 第N个素数
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        int num = 2;
        while (cnt < n) {
            if (isPrime(num)) {
                cnt++;
                if (cnt >= m) {
                    // 达到第M个素数之后，开始存入到链表中
                    list.add(num);
                }
            }
            num++;
        }
        cnt = 0;
        // list存的都是素数
        for (int i = 0; i < list.size(); i++) {
            cnt++; // 从1开始
            if (cnt % 10 != 1) {
                System.out.print(" ");// 把空格先处理 一个空格加一个数字  我是数字跟空格
            }
            System.out.print(list.get(i));
            if (cnt % 10 == 0) {
                System.out.println();
            }
        }
    }
}
