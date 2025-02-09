package cn.xyf.datastruct.graph;

import java.util.List;
import java.util.Objects;

/**
 * @author Xuyifeng
 * @description 顶点
 * @date 2025/2/7 12:02
 */

public class Vertex {

    String name;
    List<Edge> edges;

    boolean visited; // 是否被访问过，用在 BFS 和 DFS
    int inDegree; // 入度
    int status; // 状态 0-未访问 1-访问中 2-访问过，用在拓扑排序

    int dist = INF; // 距离，用在Dijkstra
    static final Integer INF = Integer.MAX_VALUE;
    Vertex prev = null; // 上一个节点，记录从何而来

    public Vertex(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.edges = List.of(new Edge(b), new Edge(c));
        b.edges = List.of(new Edge(d));
        c.edges = List.of(new Edge(d));
        d.edges = List.of();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
