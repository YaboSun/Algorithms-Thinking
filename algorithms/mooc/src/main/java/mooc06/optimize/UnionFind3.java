package mooc06.optimize;

/**
 * @author YaboSun
 *
 * 第三版UnionFind
 */
public class UnionFind3 {
    private int[] parent;
    int[] sz; // sz[i]表示以i为根的集合中的元素个数
    int count;

    public UnionFind3(int count) {
        this.parent = new int[count];
        this.count = count;
        sz = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            sz[i] = 1;
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
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot]; // 维护qRoot元素个数
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

    }
}
