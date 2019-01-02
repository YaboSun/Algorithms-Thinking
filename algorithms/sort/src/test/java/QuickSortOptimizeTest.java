import common.SortTestHelper;
import org.junit.Test;
import quick.QuickSortOptimize;

/**
 * Created by hadoop on 18-10-6
 */
public class QuickSortOptimizeTest {
    QuickSortOptimize quickSortOptimize = null;
    @Test
    public void quickSort() {
        int n = 1000000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, 1000);
        quickSortOptimize = new QuickSortOptimize(arr, n);
        SortTestHelper.isSorted(arr, n);
    }
}