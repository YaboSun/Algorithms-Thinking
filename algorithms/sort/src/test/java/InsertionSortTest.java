import utils.SortTestHelper;
import insertion.InsertionSort;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by hadoop on 18-9-26
 */
public class InsertionSortTest {
    InsertionSort insertionSort = null;

    @Test
    public void insertionSortTest() {
        int n = 10;
        int rangeL = 1;
        int rangeR = 1000;
        int[] arr = SortTestHelper.generateNearlyOrderedArray(n, 5);
        SortTestHelper.printArr(arr);
        insertionSort = new InsertionSort();

        insertionSort.insertionSort(arr, n);
        assertTrue(SortTestHelper.isSorted(arr, n));
        SortTestHelper.printArr(arr);
    }

    @Test
    public void insertionSortIATest() {
        int n = 6;
        int[] arr = SortTestHelper.generateNearlyOrderedArray(n, 5);
        SortTestHelper.printArr(arr);
        insertionSort = new InsertionSort();

        insertionSort.insertionSortIA(arr, n);
        assertTrue(SortTestHelper.isSorted(arr, n));
        SortTestHelper.printArr(arr);
    }

    @Test
    public void descInsertionSortTest() {
        int n = 10;
        int[] arr = SortTestHelper.generateNearlyOrderedArray(n, 5);
        SortTestHelper.printArr(arr);
        insertionSort = new InsertionSort();

        insertionSort.descInsertionSort(arr, n);
        SortTestHelper.printArr(arr);
    }
}