package insertion;

/**
 * @author YaboSun
 * @since Created in 18-10-18
 *
 * 插入排序
 * 对于近乎有序的数组排序的效率非常高，如果是完全有序的就是o（n）级别，
 * 另外一点就是通过插入排序引申希尔排序，整体思路就是插入排序的延伸
 */
public class InsertionSort {

    /**
     * 插入排序实现
     * @param arr 待排序数组
     * @param n 数组元素个数
     */
    public void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            // 第一种实现，细节没有优化，只是将所有的都比较了一遍
            /*for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    SortTestHelper.swap(arr, i, j);
                } else {
                    break;
                }
            }*/

            // 第二种实现，标准讲解
            /*for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                    SortTestHelper.swap(arr, j, j - 1);
            }*/

            // 第三种实现，基于前面一种进行优化，主要是不使用原有的swap减少赋值的次数
            int element = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > element; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = element;
        }
    }
}
