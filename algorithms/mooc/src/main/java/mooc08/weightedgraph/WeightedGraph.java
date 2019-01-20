package mooc08.weightedgraph;

/**
 * @author YaboSun
 */
interface WeightedGraph<Weight extends Number & Comparable> {

    /**
     * 获得顶点
     * @return 对应的顶点
     */
    int V();

    /**
     * 获得对应的边
     * @return 对应的边
     */
    int E();

    /**
     * 添加边
     */
    void addEdge(Edge<Weight> e);

    /**
     * 判断两节点是否有边连接
     * @param v 节点v
     * @param w 节点w
     * @return 如果有边返回true
     */
    boolean hasEdge(int v, int w);

    /**
     * 打印有权图的信息
     */
    void show();

    /**
     * 返回节点v的所有邻边
     * @param v 节点v
     * @return 所有邻边
     */
    Iterable<Edge<Weight>> adj(int v);
}
