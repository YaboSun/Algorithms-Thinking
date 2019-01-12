package mooc05.orderedlist;

/**
 * @author YaboSun
 *
 * 递归实现折半查找
 */
public class BinarySearchRecur {
    public int binarySearchRecur(int[] arr, int low, int high, int target) {
        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchRecur(arr, low, mid - 1, target);
        } else {
            return binarySearchRecur(arr, mid + 1, high, target);
        }

    }
}
