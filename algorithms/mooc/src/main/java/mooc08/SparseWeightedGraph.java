package mooc08;

import java.util.ArrayList;

/**
 * @author YaboSun
 */
public class SparseWeightedGraph<Weight extends Number & Comparable>
        implements WeightedGraph {

    private int nodes;
    private int edges;
    private boolean directed;
    private ArrayList<Edge<Weight>>[] g;

    public SparseWeightedGraph(int nodes, boolean directed) {
        assert nodes >= 0;
        this.nodes = nodes;
        this.nodes = 0;
        this.directed = directed;

        g = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            g[i] = new ArrayList<>();
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

        // 注意, 由于在邻接表的情况, 查找是否有重边需要遍历整个链表
        // 从效率上讲 这个损失很大性能 这里实现我们的程序允许重边的出现

        g[e.getV1()].add(new Edge(e));
        if (e.getV1() != e.getV2() && !directed) {
            g[e.getV2()].add(new Edge(e.getV1(), e.getV2(), e.getWeight()));
        }

        edges++;
    }

    @Override
    public boolean hasEdge(int v, int w) {

        assert v >= 0 && v < nodes;
        assert w >= 0 && w < nodes;

        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].get(i).other(i) == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for( int i = 0 ; i < nodes ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ ){
                Edge e = g[i].get(j);
                System.out.print( "( to:" + e.other(i) + ",wt:" + e.getWeight() + ")\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < nodes;
        return g[v];
    }
}
