package mooc08.kruskal;

import mooc08.weightedgraph.DenseWeightedGraph;
import mooc08.weightedgraph.Edge;
import mooc08.weightedgraph.ReadWeightedGraph;
import mooc08.weightedgraph.SparseWeightedGraph;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class KruskalMSTTest {

    public static void main(String[] args) {

        String filename = "testWG1.txt";
        int V = 8;

        DenseWeightedGraph<Double> g1 = new DenseWeightedGraph<>(V, false);
        /*SparseWeightedGraph<Double> g2 = new SparseWeightedGraph<>(V, false);*/
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g1, filename);

        // Test Kruskal
        System.out.println("Test Kruskal:");
        KruskalMST<Double> kruskalMST = new KruskalMST<Double>(g1);
        ArrayList<Edge<Double>> mst = kruskalMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.get(i));
        System.out.println("The MST weight is: " + kruskalMST.result());

        System.out.println();

    }
}