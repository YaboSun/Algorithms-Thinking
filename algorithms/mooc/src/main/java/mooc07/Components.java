package mooc07;

/**
 * @author YaboSun
 *
 * 求无权图的联通分量
 */
public class Components {

    Graph G;
    private boolean[] visited;
    private int ccount;
    private int[] id; // 用于判断是否连通


    public Components(Graph graph) {

        G = graph;
        visited = new boolean[G.V()];
        ccount = 0;
        id = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }

        // 求图的联通分量
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    private void dfs(int v) {

        visited[v] = true;
        id[v] = ccount; // 如果两点连通就id相同，否则不相同

        for (int i : G.adj(v)) {
            if (!visited[v]) {
                dfs(i);
            }
        }
    }

    public boolean isConnected(int v, int w) {
        assert v >= 0 && v <G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }


}
