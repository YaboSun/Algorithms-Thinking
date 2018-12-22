package bubble;

import common.SortTestHelper;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class BubbleSortTest {
    BubbleSort bubbleSort = new BubbleSort();
    @Test
    public void bubbleSort() {
        int n = 5;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, 100);
        SortTestHelper.printArr(arr);
        bubbleSort.bubbleSort(arr);

        SortTestHelper.printArr(arr);
        assertTrue(SortTestHelper.isSorted(arr, n));
    }
}