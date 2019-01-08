package merge;

import utils.SortTestHelper;
import org.junit.Test;


/**
 * @author YaboSun
 */
public class GenericMergeSortTest {

    @Test
    public void mergeSort() {
        int n = 10;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, 10);
        SortTestHelper.printArr(arr);
        GenericMergeSort.mergeSort(arr);
        SortTestHelper.isSorted(arr, n);
        SortTestHelper.printArr(arr);
    }
}