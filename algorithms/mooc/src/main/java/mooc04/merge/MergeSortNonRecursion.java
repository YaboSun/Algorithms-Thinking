package mooc04.merge;

/**
 * @author YaboSun
 * @since Created in 18-10-18
 *
 * 归并排序的非递归实现，即自底向上实现
 */
public class MergeSortNonRecursion {

    // 为了方便起见 其中一些方法需要调用递归实现
    MergeSortRecursion mergeSortRecursion = new MergeSortRecursion();

    /**
     * 非递归实现归并排序
     * @param arr 待排序数组
     * @param n 数组元素个数
     */
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
