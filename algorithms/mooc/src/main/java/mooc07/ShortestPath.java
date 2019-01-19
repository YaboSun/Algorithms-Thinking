package mooc07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author YaboSun
 */
public class ShortestPath {

    private Graph G; // 图的引用
    private int start; // 图的起始点
    private boolean[] visited; // 记录dfs过程中节点是否被访问
    private int[] from; // 记录路径，from[i]表示查找的路径上i的上一个结点
    private int[] ord; // 记录路径中节点的次序，ord[i]表示i节点在路径中的次序

    public ShortestPath(Graph graph, int start) {
        G = graph;
        assert start >= 0 && start < G.V();
        this.start = start;

        visited = new boolean[G.V()];
        from = new int[G.V()];
        ord = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }

        // 无向图最短路径算法，从start开始广度优先遍历整张图
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int i : G.adj(v)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] += 1;
                }
            }
        }
    }

    // 查询从start到w是否有路径
    public boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    // 查询从start到w的路径存在一个ArrayList中
    public ArrayList<Integer> path(int w) {

        assert hasPath(w);

        Stack<Integer> s = new Stack<>();
        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!s.isEmpty()) {
            res.add(s.pop());
        }

        return res;

    }

    // 打印出start到w的路径
    public void showPath(int w) {

        assert hasPath(w);

        ArrayList<Integer> arrayList = path(w);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
            if (i == arrayList.size() - 1) {
                System.out.println();
            } else {
                System.out.print("->");
            }
        }
    }

    // 查看从s点到w点的最短路径长度
    // 若从s到w不可达，返回-1
    public int length(int w) {
        assert w >= 0 && w < G.V();
        return ord[w];
    }
}
