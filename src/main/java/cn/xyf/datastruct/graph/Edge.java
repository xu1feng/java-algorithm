package cn.xyf.datastruct.graph;

/**
 * @author Xuyifeng
 * @description 边
 * @date 2025/2/7 12:03
 */

public class Edge {

    Vertex linked;
    int weight;

    public Edge(Vertex linked) {
        this(linked, 1);
    }

    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }

}
