package graph.minimumSpanningtree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YaboSun
 *
 */
public class Kruskal {
    /**
     * 定义边数量的最大值
     */
    private static final int MAXEDGE = 15;
    /**
     * 定义顶点个数的最大值
     */
    private static final int MAXVEX = 9;

    public void miniSpanTree_Kruskal(int[][] graph) {
        int i;
        int n;
        int m;
        List<Edge> edges = new ArrayList<>(MAXEDGE);
        int[] parent = new int[MAXVEX];
        // TODO 将传入的矩阵数组转化为边集数组并按权有小到大排列
        for (i = 0; i < graph.length; i++) {
            parent[i] = 0;
        }
        for (i = 0; i < graph.length; i++) {
            n = find(parent, edges.get(i).begin);
            m = find(parent, edges.get(i).end);
            if (n != m) {
                parent[n] = m;
                System.out.println(edges.get(i).begin + " " + edges.get(i).end + " " + edges.get(i).weight);
            }
        }
    }

    private int find(int[] parent, int f) {
        while (parent[f] > 0) {
            f = parent[f];
        }
        return f;
    }


    private static class Edge {
        int begin;
        int end;
        int weight;

        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }
    }

}
