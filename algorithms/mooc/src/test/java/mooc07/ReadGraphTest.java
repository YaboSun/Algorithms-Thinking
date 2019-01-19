package mooc07;

/**
 * @author YaboSun
 */
public class ReadGraphTest {

    public static void main(String[] args) {

        String fileName = "testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, fileName);
        System.out.println("test G1 in Sparse Graph");
        g1.show();

        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2, fileName);
        System.out.println("test G2 in dense Graph");
        g2.show();
    }
}