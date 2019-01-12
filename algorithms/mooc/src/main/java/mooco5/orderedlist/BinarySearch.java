package mooco5.orderedlist;

/**
 * @author YaboSun
 */
public class BinarySearch {

    /**
     * 折半查找 非递归实现 数组一定是有序的
     * @param arr 有序数组
     * @param n 数组最大下标
     * @param target 目标查找值
     * @return 返回目标值所在下标
     */
    public int binarySearchOne(int[] arr, int n, int target) {
        // 在arr[low...high]之中查找target
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

    /**
     * 慕课网视频代码实现
     * 在有序数组中查找target，如果找到返回相应索引的index
     * 如果没找到返回-1
     * @param arr 有序数组
     * @param n 数组元素个数
     * @param target 目标查找值
     * @return 返回索引下标
     */
    public int binarySearchTwo(int[] arr, int n, int target) {
        // 在arr[l...r]之中查找target
        int l = 0;
        int r = n - 1;


        while (l <= r) {
            // int mid = (l + r) / 2;
            // 这个部分对于l r都是int型 可能出现相加溢出的情况,无bug版本如下
            int mid = l + (r - l) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 使用类似模板类实现可变参数类型
     * @param arr
     * @param target
     * @return
     */
    public int binarySearchTemplate(Comparable[] arr, Comparable target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
