package mooc08.prim;

import mooc08.weightedgraph.Edge;
import mooc08.weightedgraph.ReadWeightedGraph;
import mooc08.weightedgraph.SparseWeightedGraph;

import java.util.ArrayList;

/**
 * @author YaboSun
 */
public class PrimMSTTest {

    public static void main(String[] args) {

        String fileName = "testWG1.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, fileName);

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
        ArrayList<Edge<Double>> mstl = lazyPrimMST.mstEdges();
        for( int i = 0 ; i < mstl.size() ; i ++ )
            System.out.println(mstl.get(i));
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();


        // Test Prim MST
        System.out.println("Test Prim MST:");
        PrimMST<Double> primMST = new PrimMST<Double>(g);
        ArrayList<Edge<Double>> mst = primMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.get(i));
        System.out.println("The MST weight is: " + primMST.result());

        System.out.println();
    }
}