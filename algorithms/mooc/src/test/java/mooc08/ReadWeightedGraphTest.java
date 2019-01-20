package mooc08;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class ReadWeightedGraphTest {
    public static void main(String[] args) {
        String fileName = "testWG1.txt";
        DenseWeightedGraph<Double> g2 = new DenseWeightedGraph<>(8, false);
        ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2, fileName);
        System.out.println("test G2 in DenseWeightedGraph");
        g2.show();
    }
}