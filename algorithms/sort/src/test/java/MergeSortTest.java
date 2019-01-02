import common.SortTestHelper;
import merge.MergeSort;
import merge.MergeSortRecursion;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by hadoop on 18-9-19
 */
public class MergeSortTest {
    MergeSort mergeSort = new MergeSort();
    MergeSortRecursion mergeSortRecursion = new MergeSortRecursion();
    /*@Test
    public void mergeSort() {
        int n = 10000;
        int rangeL = 0;
        int rangeR = 10000;
        int[] arr = SortTestHelper.generateRandomArray(n, rangeL, rangeR);
        mergeSort.mergeSort(arr, n);
    }*/

    @Test
    public void mergeSortTwo() {
        int[] arr = {1, 2, 3, 6, 4, 5, 7, 8};
        int n = 8;
        mergeSortRecursion.sort(arr, 0, 7);
        assertTrue(arr[0] == 1);
        assertTrue(arr[1] == 2);
        assertTrue(arr[2] == 3);
        assertTrue(arr[3] == 4);
    }
}