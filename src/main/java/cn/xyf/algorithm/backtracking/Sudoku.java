package cn.xyf.algorithm.backtracking;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 解数独
 * @date 2025/2/15 16:48
 */

public class Sudoku {

    public void solveSudoku(char[][] board) {
        /*
            1. 不断遍历每个未填的空格
                逐一尝试 1~9 若行、列、九宫格内没有冲突，则填入
            2. 一旦 1~9 都尝试失败，回溯到上一次状态，换数字填入
            3. 关键还是要记录冲突状态
         */
        // 行冲突状态
        boolean[][] ca = new boolean[9][9];
        // 列冲突状态
        boolean[][] cb = new boolean[9][9];
        // 九宫格冲突状态 i/3*3+j/3
        boolean[][] cc = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') { // 初始化冲突状态
                    ca[i][ch - '1'] = true; // '5' - '1' = 4
                    cb[j][ch - '1'] = true;
                    cc[i / 3 * 3 + j / 3][ch - '1'] = true;
                }
            }
        }
        dfs(0, 0, board, ca, cb, cc);
    }

    static boolean dfs(int i, int j, char[][] board, boolean[][] ca, boolean[][] cb, boolean[][] cc) {
        while (board[i][j] != '.') { // 查找下一个空位
            if (++j >= 9) {
                j = 0;
                i++;
            }
            if (i >= 9) {
                return true; // 找到解
            }
        }
        // 填空
        for (int x = 1; x <= 9; x++) {
            // 检查冲突
            if (ca[i][x - 1] || cb[j][x - 1] || cc[i / 3 * 3 + j / 3][x - 1]) {
                continue;
            }
            // 填入数字
            board[i][j] = (char) (x + '0');
            // ca[0][0] = true 代表第 1 行不能存储 '1'
            // cb[2][0] = true 代表第 3 列不能存储 '1'
            // cc[0][0] = true 代表第 1 个九宫格不能存储 '1'
            // 记录填入数字后的冲突
            ca[i][x - 1] = cb[j][x - 1] = cc[i / 3 * 3 + j / 3][x - 1] = true;
            if (dfs(i, j, board, ca, cb, cc)) {
                return true;
            }
            board[i][j] = '.';
            ca[i][x - 1] = cb[j][x - 1] = cc[i / 3 * 3 + j / 3][x - 1] = false;
        }
        return false;
    }

    static char[][] solved = {
            {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
            {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
    };

    static void print(char[][] table) {
        for (char[] chars : table) {
            System.out.println(new String(chars));
        }
        System.out.println(Arrays.deepEquals(table, solved));
    }

    public static void main(String[] args) {
        char[][] table = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        new Sudoku().solveSudoku(table);

        print(table);
    }

}
