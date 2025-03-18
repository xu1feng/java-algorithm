package cn.xyf.pat.yi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/9 14:34
 */

public class Test10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        boolean hasOutput = false;

        while (scanner.hasNextInt()) {
            int coefficient = scanner.nextInt();  // 系数
            int exponent = scanner.nextInt();     // 指数

            if (exponent != 0) {
                // 计算导数后的系数和指数
                int newCoefficient = coefficient * exponent;
                int newExponent = exponent - 1;

                // 格式化输出结果
                result.append(hasOutput ? " " : "")
                        .append(newCoefficient)
                        .append(" ")
                        .append(newExponent);
                hasOutput = true;
            }
        }

        // 处理零多项式情况
        System.out.println(hasOutput ? result.toString() : "0 0");
        scanner.close();
    }

}
