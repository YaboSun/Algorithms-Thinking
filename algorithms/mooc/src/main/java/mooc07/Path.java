package mooc07;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author YaboSun
 */
public class Path {

    private Graph G;
    private int start;
    private boolean[] visited;
    private int[] from; // 记录路径，from[i]表示查找的路径上i的上一个节点

    private void dfs(int v) {

        visited[v] = true;
        for (int i : G.adj(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    public Path(Graph graph, int start) {

        G = graph;
        assert start >= 0 && start < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.start = start;
    }

    public boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    public ArrayList<Integer> path(int w) {

        assert hasPath(w);

        Stack<Integer> stack = new Stack<>();
        int p = w;
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }

    public void showPath(int w) {

        assert hasPath(w);

        ArrayList<Integer> arrayList = path(w);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
            if (i == arrayList.size() - 1) {
                System.out.println();
            } else {
                System.out.println("->");
            }
        }
    }
}
