package cn.xyf.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 15:24
 */

public class Leetcode51 {

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = solveNQueens(n);
        for (List<String> solution : result) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println("----------------------");
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] ca = new boolean[n]; // 记录列冲突
        boolean[] cb = new boolean[2 * n - 1]; // 记录左斜线冲突 i + j
        boolean[] cc = new boolean[2 * n - 1]; // 记录右斜线冲突 n-1-(i-j)
        char[][] table = new char[n][n]; // '.'  'Q'
        for (char[] t : table) {
            Arrays.fill(t, '.');
        }
        dfs(0, n, table, ca, cb, cc, result);
        return result;
    }

    static void dfs(int i, int n, char[][] table, boolean[] ca, boolean[] cb, boolean[] cc, List<List<String>> result) {
        if (i == n) { // 找到解
            List<String> solution = new ArrayList<>();
            for (char[] chars : table) {
                solution.add(new String(chars));
            }
            result.add(solution);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (ca[j] || cb[i + j] || cc[n - 1 - (i - j)]) {
                continue;
            }
            table[i][j] = 'Q';
            ca[j] = true;
            cb[i + j] = true;
            cc[n - 1 - (i - j)] = true;
            dfs(i + 1, n, table, ca, cb, cc, result);
            table[i][j] = '.';
            ca[j] = false;
            cb[i + j] = false;
            cc[n - 1 - (i - j)] = false;
        }
    }

}
