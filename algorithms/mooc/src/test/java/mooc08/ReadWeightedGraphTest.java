package mooc08;

import mooc08.weightedgraph.DenseWeightedGraph;
import mooc08.weightedgraph.ReadWeightedGraph;
import mooc08.weightedgraph.SparseWeightedGraph;

/**
 * @author YaboSun
 */
public class ReadWeightedGraphTest {
    public static void main(String[] args) {
        String fileName = "testWG1.txt";

        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<>(8, false);
        ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1, fileName);
        System.out.println("test G1 in SparseWeightedGraph");
        g1.show();

        DenseWeightedGraph<Double> g2 = new DenseWeightedGraph<>(8, false);
        ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2, fileName);
        System.out.println("test G2 in DenseWeightedGraph");
        g2.show();
    }
}