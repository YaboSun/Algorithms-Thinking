import common.SortTestHelper;
import org.junit.Test;
import select.SelectSort;

/**
 * Created by hadoop on 18-9-20
 */
public class SelectSortTest implements SortTestHelper {
    SelectSort selectSort = new SelectSort();

    @Test
    @Override
    public void calculateSortTime() {
        long startTime = System.currentTimeMillis();
        selectionSort();
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("选择排序所用时间为：" + (endTime - startTime) + "毫秒");
    }

    @Test
    public void selectionSort() {
        int n = 10000;
        int rangeL = 0;
        int rangeR = 9999;
        int[] arr = SortTestHelper.generateRandomArray(n, rangeL, rangeR);
        /*int[] arr = {1,3,2,9,4,6,5,8,7};
        int n = 9;*/
        SortTestHelper.printArr(arr);
        System.out.println();
        selectSort.selectionSort(arr, n);
        SortTestHelper.printArr(arr);

    }
}