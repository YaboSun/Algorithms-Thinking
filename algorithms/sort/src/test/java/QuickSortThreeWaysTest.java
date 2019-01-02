import common.SortTestHelper;
import org.junit.Test;
import quick.QuickSortThreeWays;

/**
 * Created by hadoop on 18-10-7
 */
public class QuickSortThreeWaysTest {
    QuickSortThreeWays quickSortThreeWays = new QuickSortThreeWays();
    @Test
    public void quickSortThreeWays() {
        int n = 10000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        quickSortThreeWays.quickSortThreeWays(arr, n);
        SortTestHelper.isSorted(arr, n);
    }
}