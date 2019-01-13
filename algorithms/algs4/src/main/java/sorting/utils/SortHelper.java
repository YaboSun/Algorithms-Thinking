package sorting.utils;

import java.util.Comparator;

/**
 * @author YaboSun
 */
public class SortHelper {

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    /**
     * 比较v、w大小
     * @param v 实现Comparable的类型
     * @param w 实现Comparable的类型
     * @return 如果v < w返回true否则返回false
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 比较v、w大小
     * @param comparator 比较器 通过其中compare方法来比较俩数大小
     * @param v 实现Comparable的类型
     * @param w 实现Comparable的类型
     * @return 如果v < w返回true否则返回false
     */
    public static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }

    /**
     * 交换数组中两个元素
     * @param a 要交换数组
     * @param i 第一个元素下标
     * @param j 第二个元素下标
     */
    public static void change(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    /**
     * 判断数组是否已经排好序
     * @param a 待排序数组
     * @return 如果已经排序完成返回true否则返回false
     */
    public static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    /**
     * 判断数组元素从a[lo] to a[hi]是否已经排好序，调用之前的less函数实现
     * @param a 待排序数组
     * @param lo low
     * @param hi high
     * @return 如果已经排序完成返回true否则返回false
     */
    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array a[] sorted?
    public static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    public static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
