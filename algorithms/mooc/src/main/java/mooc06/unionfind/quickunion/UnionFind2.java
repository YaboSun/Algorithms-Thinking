package mooc06.unionfind.quickunion;

/**
 * @author YaboSun
 *
 * 第二个版本的UnionFind
 */
public class UnionFind2 {

    private int[] parent;
    int count;

    public UnionFind2(int count) {
        this.parent = new int[count];
        this.count = count;

        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        assert p >= 0 && p < count;
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }
}
