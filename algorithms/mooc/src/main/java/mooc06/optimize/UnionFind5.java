package mooc06.optimize;

/**
 * @author YaboSun
 *
 * 并查集第五种实现方式 路径压缩算法
 *
 * 前面都是在union方面进行优化，还可以在find过程中进行优化
 *
 */
public class UnionFind5 {
    private int[] parent; // parent[i]表示第i个元素所指向的父节点
    private int[] rank; // rank[i]表示以i为根的集合所表示的树的层数
    private int count; // 数据个数

    public UnionFind5(int count) {
        parent = new int[count];
        rank = new int[count];
        this.count = count;
        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // 查找过程, 查找元素p所对应的集合编号
    // O(h)复杂度, h为树的高度
    private int find(int p) {
        assert( p >= 0 && p < count );
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p

        // 路径压缩核心代码 第一版
        /*while( p != parent[p] ){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }*/

        // 路径压缩核心代码 第二版
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }

        //return p;
        return parent[p];
    }

    // 查看元素p和元素q是否所属一个集合
    // O(h)复杂度, h为树的高度
    public boolean isConnected( int p , int q ){
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(h)复杂度, h为树的高度
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
