import utils.SortTestHelper;
import insertion.InsertionSort;
import merge.MergeSortRecursion;
import org.junit.Test;
import quick.QuickSort;
import select.SelectSort;

import static org.junit.Assert.assertTrue;

/**
 * Created by hadoop on 18-9-25
 *
 * 通过利用SortTestHelper随机产生一个数组从而可以适用不同的数组来进行计算运行时间
 */

public class SortTimeTest implements SortTestHelper {
    // 定义所要计算的排序类
    SelectSort selectSort = null;
    QuickSort quickSort = null;
    InsertionSort insertionSort = null;
    MergeSortRecursion mergeSortRecursion = null;

    // 定义参数用于生成随机数组
    private int n = 50000;
    private int rangeL = 0;
    private int rangeR = 10000;
    private int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
    private int[] newArr1 = SortTestHelper.copyIntArray(arr, n);
    private int[] newArr2 = SortTestHelper.copyIntArray(arr, n);
    private int[] newArr3 = SortTestHelper.copyIntArray(arr, n);
    // 定义用于计算时间的对象
    private long startTime;
    private long endTime;
    @Test
    @Override
    public void calculateSortTime() {
        // 计算选择排序所用时间
        selectSort = new SelectSort();
        startTime = System.currentTimeMillis();
        selectSort.selectionSort(arr, n);
        endTime = System.currentTimeMillis();
        System.out.println("选择排序所用时间：" + (endTime - startTime) + "ms");
        assertTrue(SortTestHelper.isSorted(arr, n));

        // 计算插入排序所用时间
        insertionSort = new InsertionSort();
        startTime = System.currentTimeMillis();
        insertionSort.insertionSort(newArr1, n);
        endTime = System.currentTimeMillis();
        System.out.println("插入排序所用时间：" + (endTime - startTime) + "ms");
        assertTrue(SortTestHelper.isSorted(newArr1, n));

        // 计算快速排序所用时间
        quickSort = new QuickSort();
        startTime = System.currentTimeMillis();
        quickSort.quickSort(newArr2, 0, newArr2.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("快速排序所用时间：" + (endTime - startTime) + "ms");
        assertTrue(SortTestHelper.isSorted(newArr2, n));

        // 计算归并排序所用时间
        mergeSortRecursion = new MergeSortRecursion();
        startTime = System.currentTimeMillis();
        mergeSortRecursion.sort(newArr3, 0, n - 1);
        endTime = System.currentTimeMillis();
        System.out.println("归并排序所用时间：" + (endTime - startTime) + "ms");
        assertTrue(SortTestHelper.isSorted(newArr3, n));
    }
}
