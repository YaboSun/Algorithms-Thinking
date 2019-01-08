package bubble;

import utils.SortTestHelper;

/**
 * @author YaboSun
 * @since Created in 18-10-18
 *
 * TODO 冒泡排序实现以及优化
 */
public class BubbleSort {
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j <= arr.length - 1; j++) {
                if (arr[j - 1] > arr[j]) {
                    SortTestHelper.swap(arr, j - 1, j);
                }
            }
        }
    }
}
