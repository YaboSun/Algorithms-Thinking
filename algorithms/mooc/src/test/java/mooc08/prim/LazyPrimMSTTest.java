package mooc08.prim;

import mooc08.weightedgraph.Edge;
import mooc08.weightedgraph.ReadWeightedGraph;
import mooc08.weightedgraph.SparseWeightedGraph;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class LazyPrimMSTTest {

    public static void main(String[] args) {

        String fileName = "testWG1.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, fileName);

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
        ArrayList<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.get(i));
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();
    }
}