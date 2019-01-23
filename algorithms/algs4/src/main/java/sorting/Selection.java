package sorting;

import sorting.utils.SortHelper;

import java.util.Comparator;

import static sorting.utils.SortHelper.*;

/**
 * @author YaboSun
 */
public class Selection {

    private Selection() {}

    /********************************************************
     *                      个人代码初步实现
     * ******************************************************/

    /**
     * 插入排序核心代码
     * 双指针进行遍历 每次找数组中最小的数，初始定义最小值为arr[0]
     * 后面依次比较，如果arr[j] < min就交换arr[i]和arr[j]
     * @param arr
     */
    public static void mySelectionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Comparable min = arr[i];
                if (arr[j].compareTo(min) < 0) {
                    SortHelper.exch(arr, i, j);
                }
            }
        }
    }

    /********************************************************
     *                      书中代码实现
     * ******************************************************/

    /**
     * Rearranges the array in ascending order, using a comparator.
     * @param a the array
     * @param comparator the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(comparator, a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, comparator, 0, i);
        }
        assert isSorted(a, comparator);
    }
}
