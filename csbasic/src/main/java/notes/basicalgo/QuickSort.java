package notes.basicalgo;

/**
 * @author YaboSun
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 2, 6};
        quickSort(nums, 0, nums.length - 1);

        // 打印
        for (int i : nums) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] nums, int l, int r) {

        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    private static int partition(int[] nums, int l, int r) {

        int key = nums[l];
        int j = l;

        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < key) {
                swap(nums, i, j + 1);
                j++;
            }
        }
        swap(nums, l, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
