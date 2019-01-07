package graph.shortestpath;

/**
 * @author YaboSun
 */
public class Floyd {

    /**
     * 求网图中各顶点ｖ到其余顶点ｗ最短路径pathMatrix[v][w]，以及带权长度shortPathTable[v][w]
     * @param graph 输入网图
     * @param pathMatrix　最短路径数组
     * @param shortPathTable　带权长度
     */
    public void shortestPath_Floyd(int[][] graph, int[][] pathMatrix, int[][] shortPathTable) {
        int v;
        int w;
        int k;

        for (v = 0; v < graph.length; ++v) {
            for (w = 0; w < graph.length; ++w) {
                shortPathTable[v][w] = graph[v][w];
                pathMatrix[v][w] = w; // 初始化
            }
        }

        for (k = 0; k < graph.length; ++k) {
            for (v = 0; v < graph.length; ++v) {
                for (w = 0; w < graph.length; ++w) {
                    if (shortPathTable[v][w] > (shortPathTable[v][k] + shortPathTable[k][w])) {
                        shortPathTable[v][w] = shortPathTable[v][k] + shortPathTable[k][w];
                        pathMatrix[v][w] = pathMatrix[v][k];
                    }
                }
            }
        }

        printMatrix(pathMatrix);
        System.out.println("---------------");
        printMatrix(shortPathTable);
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j : matrix[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
