import utils.SortTestHelper;
import org.junit.Test;
import quick.QuickSortImooc;

/**
 * Created by hadoop on 18-10-3
 */
public class QuickSortImoocTest {

    QuickSortImooc quickSortImooc = null;
    @Test
    public void quickSort() {
        int n = 1000000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        quickSortImooc = new QuickSortImooc(arr, n);
        SortTestHelper.isSorted(arr, n);
    }
}