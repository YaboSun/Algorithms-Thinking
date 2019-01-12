package mooc04.quick;

import mooc04.utils.SortTestHelper;

/**
 * @author YaboSun
 * @since Created in 18-10-18
 */
public class QuickSortImooc {
    public QuickSortImooc(int[] arr, int n) {
        quickSort(arr, 0, n - 1);
    }

    /**
     * 对arr[l...r]部分进行快速排序
     * @param arr 待排序数组
     * @param l 数组左边界
     * @param r 数组右边界
     */
    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    /**
     * 对arr[l...r]部分进行partition操作
     * @param arr 传入数组
     * @param l 数组左边界
     * @param r 数组右边界
     * @return j 返回索引j，使得arr[l...j-1] < arr[j];arr[j+1...r] > arr[j]
     */
    public int partition(int[] arr, int l, int r) {
        /**
         * 定义取数组的第一个元素为标准元素
         */
        int v = arr[l];
        /**
         * 定义一个索引下标j使满足
         * arr[l + 1...j] < v ; arr[j+1...i]>v
         */
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                SortTestHelper.swap(arr, j + 1, i);
                j++;
            }
        }
        SortTestHelper.swap(arr, l, j);
        return j;
    }
}
