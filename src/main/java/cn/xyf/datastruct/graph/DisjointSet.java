package cn.xyf.datastruct.graph;

import java.util.Arrays;

/**
 * @author Xuyifeng
 * @description 不相交集合（并查集合）
 * @date 2025/2/9 15:10
 */

public class DisjointSet {

    int[] s;
    int[] size;
    // 索引对应顶点
    // 元素是用来表示与之有关系的顶点
    /*
        索引  0  1  2  3  4  5  6
        元素 [0, 1, 2, 3, 4, 5, 6] 表示一开始顶点直接没有联系（只与自己有联系）

    */

    public DisjointSet(int size) {
        s = new int[size];
        this.size = new int[size];
        for (int i = 0; i < size; i++) {
            s[i] = i;
            this.size[i] = 1;
        }
    }

    // find 是找到老大 - 优化：路径压缩
    public int find(int x) {
        if (x == s[x]) {
            return x;
        }
        return s[x] = find(s[x]);
    }

    // union 是让两个集合“相交”，即选出新老大，x、y 是原老大索引
    // 优化 union by size
    public void union(int x, int y) {
        if (size[x] < size[y]) {
            // y 老大 x 小弟
            s[x] = y;
            size[y] = size[y] + size[x]; // 更新老大的元素个数
        } else {
            // x 新老大 y 新小弟
            s[y] = x;
            size[x] = size[x] + size[y]; // 更新老大的元素个数
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(s);
    }

}
