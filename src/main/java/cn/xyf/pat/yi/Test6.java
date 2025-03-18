package cn.xyf.pat.yi;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/9 14:03
 */

public class Test6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        StringBuffer numNew = new StringBuffer();
        for (int i = 1; i <= num % 10; i++) {
            numNew.append(i);
        }
        int count = 0;
        if (num / 10 % 10 != 0) { // 取十位上的数字
            int cnt = num / 10 % 10;
            for (int i = 0; i < cnt; i++) {
                numNew.insert(0, "S");
            }
        }
        if (num / 100 != 0) { // 取百位上的数字
            int cnt = num / 100;
            for (int i = 0; i < cnt; i++) {
                numNew.insert(0, "B");
            }
        }
        System.out.println(numNew);
    }

}
