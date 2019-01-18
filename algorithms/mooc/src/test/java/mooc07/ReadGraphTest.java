package mooc07;

/**
 * @author YaboSun
 */
public class ReadGraphTest {

    public static void main(String[] args) {

        String fileName = "testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph = new ReadGraph(g1, fileName);
        System.out.println("test G1 in Sparse Graph");
        g1.show();
    }
}