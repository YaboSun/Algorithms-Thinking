package mooc08.prim;

import mooc04.heap.IndexMinHeap;
import mooc08.weightedgraph.Edge;
import mooc08.weightedgraph.WeightedGraph;

import java.util.ArrayList;

/**
 * @author YaboSun
 */

// 使用优化的Prim算法求图的最小生成树
// 时间复杂度提升为elogv
public class PrimMST<Weight extends Number & Comparable> {

    private WeightedGraph G; // 图的引用
    private IndexMinHeap<Weight> ipq; // 最小索引堆 算法辅助数据结构
    private Edge<Weight>[] edgeTo; // 访问的点所对应的边，算法辅助数据结构
    private boolean[] marked; // 标记数组 在算法运行过程中标记i是否被访问过
    private ArrayList<Edge<Weight>> mst; // 最小生成树包含的所有边
    private Number mstWeight; // 最小生成树的权值

    // 构造函数 使用prim算法求图的最小生成树
    public PrimMST(WeightedGraph graph) {

        G = graph;
        assert (graph.E() >= 1); // 保证当前边数大于等于1
        ipq = new IndexMinHeap<>(graph.V()); // 创建一个节点数为v的最小索引堆

        // 算法初始化
        marked = new boolean[G.V()]; // 创建一个顶点大小的数组 因为后面操作都是判断每个顶点是否被访问过
        edgeTo = new Edge[G.V()]; // 创建一个顶点大小的数组 用于保存边
        for (int i = 0; i < G.V(); i++) { // 初始化
            marked[i] = false;
            edgeTo[i] = null;
        }
        mst = new ArrayList<>();

        // prim算法核心实现
        visit(0); // 从第一个顶点开始访问
        while (!ipq.isEmpty()) {
            // 使用最小索引堆找到已经访问的边中权值最小的边
            // 最小索引对中存储的是结点的索引，通过点的索引找到对应的边
            int v = ipq.extractMinIndex();
            assert (edgeTo[v] != null);
            mst.add(edgeTo[v]);
            visit(v);
        }

        // 计算最小生成树的权值
        mstWeight = mst.get(0).getWeight();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight = mstWeight.doubleValue() + mst.get(i).getWeight().doubleValue();
        }
    }

    // 访问结点v
    private void visit(int v) {

        assert !marked[v]; // 保证节点v没有被访问过
        marked[v] = true; // 开始第一次访问 所以先将其置为true

        // 将和节点v相连接未访问的另外一个节点以及对应的边 放入最小堆中
        for (Object item : G.adj(v)) {
            Edge<Weight> e = (Edge<Weight>) item; // 将item转化为edge类型
            int w = e.other(v); // 通过对应的边找另外一个节点
            if (!marked[w]) { // 如果对应的另外一个节点没有被访问
                // 如果从来没有考虑过这个端点 直接将这个端点和与之连接的边加入索引堆
                if (edgeTo[w] == null) {
                    edgeTo[w] = e;
                    ipq.insert(w, e.getWeight());
                } else if (e.getWeight().compareTo(edgeTo[w].getWeight()) < 0) { // 如果最新的值小于原有的值 替换
                    edgeTo[w] = e;
                    ipq.change(w, e.getWeight());
                }
            }
        }
    }

    // 返回最小生成树的所有边
    public ArrayList<Edge<Weight>> mstEdges() {
        return mst;
    }

    // 返回最小生成树的权值
    public Number result() {
        return mstWeight;
    }
}
