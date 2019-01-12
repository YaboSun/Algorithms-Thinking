package mooc04.select;

import mooc04.utils.SortTestHelper;

/**
 * @author YaboSun
 * @since Created in 18-10-18
 *
 * 选择排序
 */
public class SelectSort {

    /**
     * 选择排序
     * @param arr 待排序数组
     * @param n 数组元素个数
     */
    public void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            SortTestHelper.swap(arr, i, minIndex);
        }
    }

}
