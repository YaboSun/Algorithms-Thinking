package mooc06.unionfind.quickfind;

/**
 * @author YaboSun
 *
 * 第一版UnionFind实现
 */
public class UnionFind1 {

    private int[] id;
    int count; // 并查集元素个数

    public UnionFind1(int n) {
        this.count = n;
        this.id = new int[n];
        // 初始化使每个元素的值都不同
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * 查找对应下标的元素值
     * 对应的时间复杂度为O(1)
     * @param p
     * @return
     */
    public int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }

    /**
     * 判断给定下标是否连接
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 时间复杂度为O(n)
     * @param p
     * @param q
     */
    public void union(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        } else {
            for (int i = 0; i < count; i++) {
                if (id[i] == pID) {
                    id[i] = qID;
                }
            }
        }
    }
}
