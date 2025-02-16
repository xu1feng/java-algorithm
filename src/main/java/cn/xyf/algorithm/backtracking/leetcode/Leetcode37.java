package cn.xyf.algorithm.backtracking.leetcode;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/2/15 16:58
 */

public class Leetcode37 {

    public void solveSudoku(char[][] board) {
        // 行冲突状态
        boolean[][] rowConflict = new boolean[9][9];
        // 列冲突状态
        boolean[][] colConflict = new boolean[9][9];
        // 九宫格冲突状态 i/3*3+j/3
        boolean[][] boxConflict = new boolean[9][9];

        // 初始化冲突状态
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    rowConflict[i][ch - '1'] = true;
                    colConflict[j][ch - '1'] = true;
                    boxConflict[i / 3 * 3 + j / 3][ch - '1'] = true;
                }
            }
        }
        dfs(0, 0, board, rowConflict, colConflict, boxConflict);
    }

    private boolean dfs(int row, int col, char[][] board, boolean[][] rowConflict, boolean[][] colConflict, boolean[][] boxConflict) {
        // 查找下一个空位
        while (row < 9 && board[row][col] != '.') {
            if (++col >= 9) {
                col = 0;
                row++;
            }
        }
        if (row == 9) {
            return true; // 找到解
        }

        // 填空
        for (int num = 1; num <= 9; num++) {
            int boxIndex = row / 3 * 3 + col / 3;
            if (rowConflict[row][num - 1] || colConflict[col][num - 1] || boxConflict[boxIndex][num - 1]) {
                continue;
            }
            // 填入数字
            board[row][col] = (char) (num + '0');
            // 更新冲突状态
            rowConflict[row][num - 1] = true;
            colConflict[col][num - 1] = true;
            boxConflict[boxIndex][num - 1] = true;

            if (dfs(row, col, board, rowConflict, colConflict, boxConflict)) {
                return true;
            }

            // 回溯
            board[row][col] = '.';
            rowConflict[row][num - 1] = false;
            colConflict[col][num - 1] = false;
            boxConflict[boxIndex][num - 1] = false;
        }
        return false;
    }

}
