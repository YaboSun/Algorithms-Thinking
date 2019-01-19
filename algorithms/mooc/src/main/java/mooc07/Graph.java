package mooc07;

/**
 * @author YaboSun
 */
public interface Graph {

    /**
     * 得到顶点数
     * @return 顶点数
     */
    public int V();

    /**
     * 得到边数
     * @return
     */
    public int E();

    /**
     * 添加边
     * @param v
     * @param w
     */
    public void addEdge(int v, int w);

    /**
     * 判断是否有边连接
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w);

    /**
     * 显示图信息
     */
    public void show();

    /**
     * 得到顶点v的所有邻接边
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v);
}
