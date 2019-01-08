import utils.SortTestHelper;
import merge.MergeSortNonRecursion;
import org.junit.Test;

/**
 * Created by hadoop on 18-10-3
 */
public class MergeSortNonRecursionTest {
    MergeSortNonRecursion mergeSortNonRecursion = new MergeSortNonRecursion();
    @Test
    public void mergeSortNonRecursion() {
        int n = 1000000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        mergeSortNonRecursion.mergeSortNonRecursion(arr, n);
        SortTestHelper.isSorted(arr, n);
    }
}