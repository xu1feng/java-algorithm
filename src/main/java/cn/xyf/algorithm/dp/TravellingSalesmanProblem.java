package cn.xyf.algorithm.dp;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Xuyifeng
 * @description 旅行商问题
 * @date 2025/2/12 15:29
 */

/*
    所有城市必须经过
 */
public class TravellingSalesmanProblem {

    /*
        北京 ->
        上海 ->
        武汉 ->
        西安 ->
                3x2=6
                (n-1)!
        北京 -> 上海 ->
                      武汉 -> 西安 -> 北京
                      西安 -> 武汉 -> 北京
               武汉 ->
                      上海 -> 西安 -> 北京
                      西安 -> 上海 -> 北京
               西安 ->
                      上海 -> 武汉 -> 北京
                      武汉 -> 上海 -> 北京

        graph
                0   1   2   3
             0  0   1   2   3
             1  1   0   6   4
             2  2   6   0   5
             3  3   4   5   0

             d(出发城市，剩余城市集合) -> 从出发城市开始，走完剩余城市，花费最少的代价
             d(0, 1|2|3) => graph[0][1] + d(1, 2|3)
                                          graph[1][3] + d(3, 2)
                                                        graph[3][2] + d(2,空)
                                                                      graph[2][0]
                                          graph[1][2] + d(2, 3)
                            graph[0][3] + d(3, 1|2)
                            graph[0][2] + d(2, 1|3)

                0   1   2   3   4   5   6   7     j  剩余城市集合
                没  1   2   12  3   13  23  123
             0
             1
             2
             3
             i  出发城市

             000 没城市    0
             001 1号      1
             010 2号      2
             100 3号      4
             011 1号和2号  3
             101 1号和3号  5
             110 2号和3号  6
             111 1和2和3   7

             出发城市 i
             剩余城市集合 j
                遍历 j 时的变量 k （剩余的某一个城市）
             d(i, j) => min(
                            g[i][k] + d(k, j去掉k)
                            g[i][k] + d(k, j去掉k)
                            g[i][k] + d(k, j去掉k)
                        )
             d(k, 空) => 从k回到起点 => g[k][i]
     */
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 2, 3},
                {1, 0, 6, 4},
                {2, 6, 0, 5},
                {3, 4, 5, 0}
        };
        System.out.println(tsp(graph));
    }

    static int tsp(int[][] g) {
        int m = g.length; //城市数目
        int n = 1 << (m - 1); // 剩余城市的组合数 2^(m-1)
        int[][] dp = new int[m][n];
        // 填充第0列
        for (int k = 0; k < m; k++) {
            dp[k][0] = g[k][0];
        }
        print(dp);
        // 填充后续列
        for (int j = 1; j < n; j++) { // 列
            for (int i = 0; i < m; i++) { // 行
                dp[i][j] = Integer.MAX_VALUE / 2;
                if (contains(j, i)) continue;
                // 填充单元格
                for (int k = 0; k < m; k++) {
                    if (contains(j, k)) {
                        dp[i][j] = Integer.min(dp[i][j], g[i][k] + dp[k][exclude(j, k)]);
                    }
                }
            }
        }
        print(dp);
        return dp[0][n - 1];
    }

    /*
        110 是否包含 0 = 0 & 1 = 0
        110 是否包含 1 = 110 & 1 = 0
        110 是否包含 2 = 11 & 1 = 1
        110 是否包含 3 = 1 & 1 = 1
        110 是否包含 4 = 0 & 1 = 0
     */
    static boolean contains(int set, int city) {
        return (set >> (city - 1) & 1) == 1;
    }

    /*
        1|2|3  1 -> 2|3

        111
       ^001
       -----
        110
     */
    static int exclude(int set, int city) {
        return set ^ (1 << (city - 1));
    }

    static void print(int[][] dist) {
        System.out.println("-------------------------");
        for (int[] row : dist) {
            System.out.println(Arrays.stream(row).boxed()
                    .map(x -> x >= Integer.MAX_VALUE / 2 ? "∞" : String.valueOf(x))
                    .map(s -> String.format("%2s", s))
                    .collect(Collectors.joining(",", "[", "]")));
        }
    }

}
