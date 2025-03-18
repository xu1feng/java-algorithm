package cn.xyf.pat.yi;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/9 14:16
 */

public class Test7 {

    private static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int sum = 0;
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        in.nextLine();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i) && isPrime(i + 2) && i + 2 <= n)
                sum++;
        }
        System.out.println(sum);
        in.close();
    }

}
