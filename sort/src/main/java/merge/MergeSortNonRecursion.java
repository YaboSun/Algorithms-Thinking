package merge;

/**
 * @author YaboSun
 * @since Created in 18-10-18
 *
 * 归并排序的非递归实现，即自底向上实现
 */
public class MergeSortNonRecursion {

    MergeSortRecursion mergeSortRecursion = new MergeSortRecursion();

    public void mergeSortNonRecursion(int[] arr, int n) {
        for (int size = 1; size <= n; size += size) {
            for (int i = 0; i + size < n; i += size + size) {

                // 对arr[i...i+size-1]和arr[i+size...i+2*size-1]进行归并
                mergeSortRecursion.merge(arr, i, i + size - 1,
                        Math.min(i + size + size -1, n -1));
            }
        }
    }
}
