package cn.xyf.pat.yi;

import java.util.Scanner;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/9 14:57
 */

public class Test12 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int x, N;
        int ans1 = 0, ans2 = 0, ans3 = 0, ans4 = 0, ans5 = 0;
        int flag2 = 0;
        int cnt4 = 0;
        N = myScanner.nextInt();
        for (int i = 0; i < N; i++) {
            x = myScanner.nextInt();
            // A1
            if (x % 5 == 0 && x % 2 == 0) {
                ans1 += x;
            }
            // A2
            if (x % 5 == 1) {
                if (flag2 % 2 == 0) {
                    ans2 += x;
                } else {
                    ans2 -= x;
                }
                flag2++;
            }
            // A3
            if (x % 5 == 2) {
                ans3++;
            }
            // A4
            if (x % 5 == 3) {
                cnt4++;
                ans4 += x;
            }
            // A5
            if (x % 5 == 4) {
                ans5 = Math.max(ans5, x); // Integer.max()
            }
        }
        if (ans1 != 0) {
            System.out.print(ans1 + " ");
        } else {
            System.out.print("N ");
        }
        if (flag2 != 0) {
            System.out.print(ans2 + " ");
        } else {
            System.out.print("N ");
        }
        if (ans3 != 0) {
            System.out.print(ans3 + " ");
        } else {
            System.out.print("N ");
        }
        if (ans4 != 0) {
            System.out.printf("%.1f ", ans4 * 1.0 / cnt4);
        } else {
            System.out.print("N ");
        }
        if (ans5 != 0) {
            System.out.print(ans5);
        } else {
            System.out.print("N");
        }
    }
}
