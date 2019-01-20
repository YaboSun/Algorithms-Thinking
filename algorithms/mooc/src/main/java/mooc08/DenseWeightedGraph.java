package mooc08;

import java.util.ArrayList;

/**
 * @author YaboSun
 */
public class DenseWeightedGraph<Weight extends Number & Comparable>
        implements WeightedGraph {

    private int nodes; // 节点数
    private int edges; // 边数
    private boolean directed; // 是否为有向图,true表示有向，false表示无向
    private Edge<Weight>[][] g; // 图的具体数据

    public DenseWeightedGraph(int nodes, boolean directed) {
        assert nodes >= 0;
        this.nodes = nodes;
        this.edges = 0;
        this.directed = directed;
        // 初始化g为n*n矩阵
        // 初始化时每一条边对应的都是null
        g = new Edge[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                g[i][j] = null;
            }
        }
    }

    @Override
    public int V() {
        return nodes;
    }

    @Override
    public int E() {
        return edges;
    }

    @Override
    public void addEdge(Edge e) {
        assert e.getV1() >= 0 && e.getV1() < nodes;
        assert e.getV2() >= 0 && e.getV2() < nodes;

        if (hasEdge(e.getV1(), e.getV2())) {
            return;
        }
        g[e.getV1()][e.getV2()] = new Edge(e);
        if (e.getV1() != e.getV2() && !directed) { // 如果不是自环而且不是有向图，就将对应的边创建权值
            g[e.getV1()][e.getV2()] = new Edge(e.getV2(), e.getV1(), e.getWeight());
        }

        edges++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < nodes;
        assert w >= 0 && w < nodes;
        return g[v][w] != null;
    }

    @Override
    public void show() {

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (g[i][j] != null) {
                    System.out.print(g[i][j].getWeight() + "\t");
                } else {
                    System.out.print("NULL\t");
                }
            }
            System.out.println();
        }

    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < nodes;
        ArrayList<Edge<Weight>> adjV = new ArrayList<Edge<Weight>>();
        for (int i = 0; i < nodes; i++) {
            if (g[v][i] != null) {
                adjV.add(g[v][i]);
            }
        }
        return adjV;
    }
}
