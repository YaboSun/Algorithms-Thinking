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
    public void miniSpanTree_Prim(int[][] graph, int n) {
        int minWeight; // 最小权值
        int i; // 用于遍历graph
        int j; // 用来顶点下标的循环变量
        int k; // 记录最小权值的顶点下标
        int[] adjvex = new int[MAXVEX]; // 保存相关顶点下标
        int[] lowcost = new int[MAXVEX];
        // 初始化得到第一行的lowcost
        for (i = 1; i < graph.length; i++) {
            lowcost[i] = graph[0][i];
            adjvex[i] = 0; // 初始化都为v0的下标
        }
        // 分别遍历得到后面结点的lowcost
        for (i = 1; i < graph.length; i++) {
            minWeight = INFINITY; // 初始化最小权值为无穷
            j = 1;
            k = 0;
            // 得到最小权值
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
