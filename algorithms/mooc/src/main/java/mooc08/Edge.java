package mooc08;

/**
 * @author YaboSun
 */
public class Edge<Weight extends Number & Comparable> implements Comparable<Edge> { // TODO 这里的Weight定义需要注意

    private int v1; // 第一个顶点
    private int v2; // 第二个顶点
    private Weight weight; // 顶点间权重

    public Edge(int v1, int v2, Weight weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public Edge(Edge<Weight> e) {
        this.v1 = e.v1;
        this.v2 = e.v2;
        this.weight = e.weight;
    }

    public int getV1() {
        return v1;
    }

    public int getV2() {
        return v2;
    }

    public Weight getWeight() {
        return weight;
    }

    public String toString() {
        return "" + v1 + "-" + v2 + ":" + weight;
    }

    @Override
    public int compareTo(Edge o) {
        if (weight.compareTo(o.getWeight()) < 0) {
            return -1;
        } else if (weight.compareTo(o.getWeight()) > 0) {
            return +1;
        } else {
            return 0;
        }
    }
}
