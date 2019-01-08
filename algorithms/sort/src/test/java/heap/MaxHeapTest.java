package heap;

import org.junit.Test;
import utils.SortTestHelper;


/**
 * @author YaboSun
 */
public class MaxHeapTest {
    @Test
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
        for (int i = 0; i < 15; i++) {
            maxHeap.insert((int) (Math.random() * 100));
        }
        SortTestHelper.printArr(maxHeap.getData());
        //assertEquals(0, maxHeap.size());
    }
}