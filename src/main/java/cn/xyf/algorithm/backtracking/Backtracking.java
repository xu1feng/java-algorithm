package cn.xyf.algorithm.backtracking;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/14 20:06
 */

import java.util.LinkedList;

/**
 * <h3>回溯</h3>
 * <ul>
 *     <li>程序在运行过程中分成了多个阶段</li>
 *     <li>通过某些手段，将数据恢复到之前某一阶段，这就称之为回溯</li>
 *     <li>手段包括</li>
 *     <ul>
 *         <li>方法栈</li>
 *         <li>自定义栈</li>
 *     </ul>
 * </ul>
 */
public class Backtracking {

    public static void main(String[] args) {
        rec(1, new LinkedList<>());
    }

    private static void rec(int n, LinkedList<String> list) {
        if (n == 3) {
            return;
        }
        System.out.println("before: " + list);
        list.push("a");
        rec(n + 1, list);
        list.pop();
        System.out.println("after: " + list);
    }

}
