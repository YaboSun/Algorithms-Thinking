import org.junit.Test;
import quick.QuickSort;

/**
 * Created by hadoop on 18-9-19
 */
public class QuickSortTest {

    @Test
    public void quickSort() {
        int[] nums = {1, 3, 4, 5, 2, 6, 9, 7, 8, 0};
        QuickSort quick = new QuickSort();
        System.out.print("排序前:");
        quick.printPart(nums, 0, nums.length - 1);
        quick.quickSort(nums, 0, nums.length - 1);
        System.out.print("排序后:");
        quick.printPart(nums, 0, nums.length - 1);
    }
}