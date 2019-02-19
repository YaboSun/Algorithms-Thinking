package mooc08.kruskal;

import mooc04.MinHeap;
import mooc06.optimize.UnionFind5;
import mooc08.weightedgraph.Edge;
import mooc08.weightedgraph.WeightedGraph;

import java.util.ArrayList;

/**
 * @author YaboSun
 */

// Kruskal算法求最小生成树
// 核心算法思想就是 首先将所有边按照权值排序
// 依次将权值最小的边加入，判断是否有环
public class KruskalMST<Weight extends Number & Comparable> {

    private ArrayList<Edge<Weight>> mst; // 最小生成树的所有边
    private Number mstWeight; // 最小生成树的权值

    // 初始化
    public KruskalMST(WeightedGraph graph) {

        mst = new ArrayList<>(); // 使用一个ArrayList保存所有边

        // 将所有边存放在一个最小堆中
        MinHeap<Edge<Weight>> pq = new MinHeap<>(graph.E()); // 创建一个大小为边数的最小堆
        for (int i = 0; i < graph.V(); i++) {
            for (Object item : graph.adj(i)) {
                Edge<Weight> e = (Edge<Weight>) item;
                if (e.getV1() <= e.getV2()) { // TODO 这里重复添加了0-2这条边
                    pq.insert(e);
                }
            }
        }

        // 创建一个并查集 判断已经访问的节点的连通情况
        UnionFind5 uf = new UnionFind5(graph.V());
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) { // 最小堆不为空 而且边的大小小于顶点个数-1

            // 从堆中依次从小到大取出所有的边
            Edge<Weight> e = pq.extractMin();
            // 判断如果取出的边的两个顶点是连通的 那么说明有环
            if (uf.isConnected(e.getV1(), e.getV2())) {
                continue;
            }

            // 否则 将这条边加入最小生成树 同时标记两个顶点连通
            mst.add(e);
            uf.unionElements(e.getV1(), e.getV2());
        }

        // 计算最小生成树的权值
        mstWeight = mst.get(0).getWeight();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight = mstWeight.doubleValue() + mst.get(i).getWeight().doubleValue();
        }
    }

    // 返回最小生成树的所有边
    public ArrayList<Edge<Weight>> mstEdges() {
        return mst;
    }

    // 返回最小生成树权值
    public Number result() {
        return mstWeight;
    }
}
