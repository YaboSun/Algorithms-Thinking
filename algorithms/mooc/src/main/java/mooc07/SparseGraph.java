package mooc07;

import java.util.ArrayList;

/**
 * @author YaboSun
 *
 * 稀疏图 使用邻接表实现
 */
public class SparseGraph implements Graph {

    private int nodes; // 节点数
    private int edges; // 边数
    private boolean directed; // 是否为有向图
    private ArrayList<Integer>[] g; // 图的具体数据,这里可以使用链表实现

    public SparseGraph(int nodes, boolean directed) {
        this.nodes = nodes;
        this.edges = 0;
        this.directed = directed;

        g = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            g[i] = new ArrayList<>();
        }
    }

    public int V() {
        return nodes;
    }

    public int E() {
        return edges;
    }

    /**
     * 向图中添加一条边
     * @param v 节点v
     * @param w 节点w
     */
    public void addEdge(int v, int w) {

        assert v >= 0 && v <= nodes;
        assert w >= 0 && w <= nodes;

        g[v].add(w);
        // 防止有自环
        if (v != w && !directed) {
            g[w].add(v);
        }

        edges++;
    }

    /**
     * 验证图中是否有从v到w的边
     * 这里主要目的是取消平行边的情况，但是这样的话时间复杂度就从常数变为了O(n)
     * 所以一般情况下从性能以及出现的概率方面考虑 不在添加边时候进行这样的判断
     * @param v 节点v
     * @param w 节点w
     * @return 如果有边返回true
     */
    public boolean hasEdge(int v, int w) {

        assert v >= 0 && v <= nodes;
        assert w >= 0 && w <= nodes;

        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].get(i) == w) {
                return true;
            }
        }

        return false;
    }

    /**
     * 显示图的信息
     */
    @Override
    public void show() {

        for (int i = 0; i < nodes; i++) {
            System.out.print("vertex" + i + ":\t");

            for (int j = 0; j < g[i].size(); j++) {
                System.out.print(g[i].get(j) + "\t");
            }

            System.out.println();
        }
    }

    /**
     * 返回图中一个顶点的所有邻边
     * @param v 顶点v
     * @return 返回顶点的所有邻边
     */
    public Iterable<Integer> adj(int v) {
        assert v >=0 && v < nodes;
        return g[v];
    }
}
