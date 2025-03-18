package cn.xyf.代码随想录.数组.螺旋矩阵Ⅱ;

/**
 * @author Xuyifeng
 * @description
 * @date 2025/3/8 21:10
 */

public class Leetcode59 {
    // 走的路径方向顺序是:右下左上
    // (0,1)代表向右走：纵坐标+1,横坐标不变，其余依次类推
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int i = 0;
        int j = 0;
        int di = 0; // 表示一开始向右
        for (int val = 1; val <= n * n; val++) { // 要填入的数
            ans[i][j] = val;
            // 试探下一步位置
            int x = i + DIRS[di][0]; //第二个[0]的意思是当前方向横坐标怎么变
            int y = j + DIRS[di][1]; //第二个[1]的意思是当前方向纵坐标怎么变
            // 怎么判断走到头：如果 (x, y) 出界或者已经填入数字
            if (x < 0 || x >= n || y < 0 || y >= n || ans[x][y] != 0) {
                // 怎么实现右转
                di = (di + 1) % 4; // 右转 90°，因为有四个方向(右下左上)，所以 % 4
            }
            // 实际移动
            i += DIRS[di][0]; //第二个[0]的意思是当前方向横坐标怎么变
            j += DIRS[di][1]; //第二个[1]的意思是当前方向纵坐标怎么变
        }
        return ans;
    }
}
