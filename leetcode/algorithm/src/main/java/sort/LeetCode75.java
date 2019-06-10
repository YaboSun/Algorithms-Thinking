package sort;

/**
 * @date 19-6-5
 *
 * 题目描述
 * 三色国旗问题：使用数字 0,1,2 分别表示红色、白色、蓝色
 * 将给定的数组排序，空间复杂度 O(1)
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class LeetCode75 {

    public void sortColors(int[] nums) {

        if (nums == null || nums.length < 2) {
            return;
        }
        int low = 0;
        int high = nums.length - 1;

        for (int i = low; i <= high;) {
            if (nums[i] == 0) {
                swap(nums, i, low);
                i++;
                low++;
            } else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

