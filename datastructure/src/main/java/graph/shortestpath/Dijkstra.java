package graph.shortestpath;

/**
 * @author YaboSun
 */
public class Dijkstra {

    private static final int MAXVEX = 9;
    private static final int INFINITY = 65535;
    /**
     * 最短路径算法-Dijkstra
     * @param graph 由二维数组构成的有向网
     * @param v0 有向网v0顶点
     * @param pathMatrix 定义用于存储最短路径下标的数组
     * @param shortPathTable 定义用于存储到个点最短路径的权值和
     */
    public void shortestPath_Dijkstra(int[][] graph, int v0, int[] pathMatrix, int[] shortPathTable) {
        int v;
        int w;
        int k = 0;
        int min;
        // final[w] = 1表示求得顶点v0到顶点vw的最短路径
        int[] finalPath = new int[MAXVEX];

        for (v = 0; v < graph.length; v++) {
            finalPath[v] = 0; // 全部顶点初始化为未知最短路径状态
            shortPathTable[v] = graph[v0][v]; // 将与v0点有连线的顶点加上权值
            pathMatrix[v] = 0; // 初始化路径数组为0
        }
        shortPathTable[v0] = 0; // v0至v0路径为0
        finalPath[v0] = 1; // v0至v0不需要求最短路径

        for (v = 1; v < graph.length; v++) {
            min = INFINITY;
            for (w = 0; w < graph.length; w++) {
                if (finalPath[w] == 0 && shortPathTable[w] < min) {
                    k = w;
                    min = shortPathTable[w]; // 表示w顶点离v0更近
                }
            }
            finalPath[k] = 1; // 将当前找到的最短路径顶点置为1
            // 修正当前最短路径及距离
            for (w = 0; w < graph.length; w++) {
                // 满足说明找到更短路径
                if (finalPath[w] == 0 && (min + graph[k][w] < shortPathTable[w])) {
                    // 修改相应下标以及权值
                    shortPathTable[w] = min + graph[k][w];
                    pathMatrix[w] = k;
                }
            }
        }

        printMatrix(pathMatrix);
        printMatrix(shortPathTable);

    }

    public void printMatrix(int[] matrix) {
        for (int i : matrix) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
