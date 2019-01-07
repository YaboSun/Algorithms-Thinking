package orderedlist;

/**
 * @author YaboSun
 */
public class BinarySearch {

    /**
     * 折半查找 非递归实现
     * @param arr 有序数组
     * @param n 数组最大下标
     * @param target 目标查找值
     * @return 返回目标值所在下标
     */
    public int binarySearch(int[] arr, int n, int target) {
        int low = 1;
        int high = n;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (target < arr[mid]) {
                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}
