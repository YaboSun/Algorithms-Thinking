package tree.minimumSpanningtree;

/**
 * @author YaboSun
 *
 * 大话数据结构prim树算法实现
 */
public class Prim {
    /**
     * 最大结点个数
     */
    private static final int MAXVEX = 9;
    /**
     * 权值极大值 表示两结点之间没有路径
     */
    private static final int INFINITY = 65535;
    /**
     * 最小生成树算法--prim算法
     * @param graph 右结点生成的二维数组
     * @param n 结点的总个数
     */
    public void MiniSpanTree_Prim(int[][] graph, int n) {
        int minWeight, i, j, k;
        int[] adjvex = new int[MAXVEX]; // 保存相关顶点下标
        int[] lowcost = new int[MAXVEX];
        for (i = 1; i < graph.length; i++) {
            lowcost[i] = graph[0][i];
            adjvex[i] = 0; // 初始化都为v0的下标
        }
        for (i = 1; i < graph.length; i++) {
            minWeight = INFINITY; // 初始化最小权值为无穷
            j = 1;
            k = 0;
            while (j < graph.length) {
                if (lowcost[j] != 0 && lowcost[j] < minWeight) {
                    minWeight = lowcost[j];
                    k = j;
                }
                j++;
            }
            System.out.println(adjvex[k] + " " + k);
            lowcost[k] = 0;
            for (j = 1; j < graph.length; j++) {
                if (lowcost[j] != 0 && graph[k][j] < lowcost[j]) {
                    lowcost[j] = graph[k][j];
                    adjvex[j] = k;
                }
            }
        }
    }
}
