package mooc07;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author YaboSun
 *
 * 稠密图 使用邻接矩阵实现
 */
public class DenseGraph {

    private int nodes; // 节点数
    private int edges; // 边数
    private boolean directed; // 是否为有向图
    private boolean[][] g; // 图的具体数据

    public DenseGraph(int nodes, boolean directed) {

        assert nodes >= 0;
        this.nodes = nodes;
        this.edges = 0; // 初始化没有任何边
        this.directed = directed;

        // g初始化为n*n的布尔矩阵 每一个g[i][i]均为false，表示没有任何边
        // false 为boolean型变量的默认值
        g = new boolean[nodes][nodes];
    }

    // 返回节点的个数
    public int V() {
        return nodes;
    }

    // 返回边的个数
    public int E() {
        return edges;
    }

    /**
     * 向图中添加一条边
     * @param v 顶点v
     * @param w 顶点w
     */
    public void addEdge(int v, int w) {

        assert v >= 0 && v <= nodes;
        assert w >= 0 && w <= nodes;

        // 判断v，w节点之间是否已经有边
        // 如果有直接返回
        if (hasEdge(v, w)) {
            return;
        }

        // 如果两节点间没有边
        // 将其设置为true表示有边
        g[v][w] = true;

        // 如果是无向边应该是对应的双向都为true
        if (!directed) {
            g[w][v] = true;
        }

        edges++;
    }

    private boolean hasEdge(int v, int w) {

        assert v >= 0 && v <= nodes;
        assert w >= 0 && w <= nodes;
        return g[v][w];
    }

    /**
     * 返回图中一个顶点的所有邻边
     * @param v 顶点v
     * @return 返回顶点的所有邻边
     */
    public ArrayList<Integer> adj(int v) {
        assert v >=0 && v < nodes;
        ArrayList<Integer> adjV = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            if (g[v][i]) {
                adjV.add(i);
            }
        }
        return adjV;
    }
}
