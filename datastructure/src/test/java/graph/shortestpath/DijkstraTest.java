package graph.shortestpath;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class DijkstraTest {
    private static final int MAX = 65535;
    private static final int MAXVEX = 9;
    Dijkstra dijkstra = new Dijkstra();
    @Test
    public void shortestPath_Dijkstra() {
        int[][] graph = new int[][] {
                { 0, 1, 5, MAX, MAX, MAX, MAX, MAX, MAX },
                { 1, 0, 3, 7, 5, MAX, MAX, MAX, MAX },
                { 5, 3, 0, MAX, 1, 7, MAX, MAX, MAX },
                { MAX, 7, MAX, 0, 2, MAX, 3, MAX, MAX },
                { MAX, 5, 1, 2, 0, 3, 6, 9, MAX },
                { MAX, MAX, 7, MAX, 3, 0, MAX, 5, MAX },
                { MAX, MAX, MAX, 3, 6, MAX, 0, 2, 7 },
                { MAX, MAX, MAX, MAX, 9, 5, 2, 0, 4 },
                { MAX, MAX, MAX, MAX, MAX, MAX, 7, 4, 0 }
        };
        int v0 = 0;
        int[] pathMatrix = new int[MAXVEX];
        int[] shortPathTable = new int[MAXVEX];
        dijkstra.shortestPath_Dijkstra(graph, v0, pathMatrix, shortPathTable);
    }
}