package cn.xyf.algorithm.backtracking;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description N皇后
 * @date 2025/2/15 15:58
 */

public class NQueen {

    public static void main(String[] args) {
        int n = 4;
        boolean[] ca = new boolean[n]; // 记录列冲突
        boolean[] cb = new boolean[2 * n - 1]; // 记录左斜线冲突 i + j
        boolean[] cc = new boolean[2 * n - 1]; // 记录右斜线冲突 n-1-(i-j)

        char[][] table = new char[n][n]; // '.'  'q'
        for (char[] t : table) {
            Arrays.fill(t, '.');
        }
        dfs(0, n, table, ca, cb, cc);

    }

    static void dfs(int i, int n, char[][] table, boolean[] ca, boolean[] cb, boolean[] cc) {
        if (i == n) { // 找到解
            System.out.println("----------------------");
            for (char[] chars : table) {
                System.out.println(new String(chars));
            }
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
            dfs(i + 1, n, table, ca, cb, cc);
            table[i][j] = '.';
            ca[j] = false;
            cb[i + j] = false;
            cc[n - 1 - (i - j)] = false;
        }
    }

}
