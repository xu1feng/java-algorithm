package cn.xyf.pat.yi;

import java.util.Scanner;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/9 15:57
 */

public class Test14 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String a, b, c, d;
        a = myScanner.nextLine();
        b = myScanner.nextLine();
        c = myScanner.nextLine();
        d = myScanner.nextLine();
        int pos = 0, i = 0, j = 0;
        char[] t = new char[2];
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        char[] cChar = c.toCharArray();
        char[] dChar = d.toCharArray();

        // 找到第一个相同的大写字母
        while (i < aChar.length && i < bChar.length) {
            if (aChar[i] == bChar[i] && (aChar[i] >= 'A' && aChar[i] <= 'G') && (bChar[i] >= 'A' && bChar[i] <= 'G'))
            {
                t[0] = aChar[i];
                break;
            }
            i++;
        }

        i = i + 1; //从下一个位置找第一个相同的字符
        while (i < aChar.length && i < bChar.length) {
//            if (aChar[i] == bChar[i] && ((aChar[i] >= 'A' && aChar[i] <= 'N') || (aChar[i] >= '0' && aChar[i] <= '9'))
//                    && ((bChar[i] >= 'A' && bChar[i] <= 'N') || (bChar[i] >= '0' && bChar[i] <= '9')))
            if (aChar[i] == bChar[i] && ((aChar[i] >= 'A' && aChar[i] <= 'N') || Character.isDigit(aChar[i]))
                    && ((bChar[i] >= 'A' && bChar[i] <= 'N') || Character.isDigit(bChar[i]))) {
                t[1] = aChar[i];
                break;
            }
            i++;
        }

        while (j < cChar.length && j < dChar.length) {
//            if (cChar[j] == dChar[j] && ((cChar[j] >= 'A' && cChar[j] <= 'Z') || (cChar[j] >= 'a' && cChar[j] <= 'z'))
//                    && ((dChar[j] >= 'A' && dChar[j] <= 'Z') || (dChar[j] >= 'a' && dChar[j] <= 'z')))
            if (cChar[j] == dChar[j] && Character.isLetter(cChar[j]) && Character.isLetter(dChar[j])) {
                pos = j; // 记录此时的位置
                break;
            }
            j++;
        }

        String[] week = new String[]{"MON ", "TUE ", "WED ", "THU ", "FRI ", "SAT ", "SUN "};
        int hour = 0;
        if (t[1] >= '0' && t[1] <= '9') {
            hour = t[1] - '0';
        } else {
            hour = t[1] - 'A' + 10;
        }
        System.out.print(week[t[0] - 'A']);
        System.out.printf("%02d:%02d", hour, pos);
    }
}
