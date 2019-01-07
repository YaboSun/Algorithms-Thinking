package tree.minimumSpanningtree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class PrimTest {
    private static final int MAX = 65535;
    Prim prim = new Prim();
    @Test
    public void miniSpanTree_Prim() {

        int[][] graph = new int[][] {
                { 0, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX },
                { 10, 0, 18, MAX, MAX, MAX, 16, MAX, 12 },
                { MAX, MAX, 0, 22, MAX, MAX, MAX, MAX, 8 },
                { MAX, MAX, 22, 0, 20, MAX, MAX, 16, 21 },
                { MAX, MAX, MAX, 20, 0, 26, MAX, 7, MAX },
                { 11, MAX, MAX, MAX, 26, 0, 17, MAX, MAX },
                { MAX, 16, MAX, MAX, MAX, 17, 0, 19, MAX },
                { MAX, MAX, MAX, 16, 7, MAX, 19, 0, MAX },
                { MAX, 12, 8, 21, MAX, MAX, MAX, MAX, 0 }
        };
        prim.miniSpanTree_Prim(graph, 9);
    }
}