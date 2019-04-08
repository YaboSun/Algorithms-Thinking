package notes;

/**
 * @author YaboSun
 *
 * 给定一个长度为 n，数组中所有数字都在 n - 1 范围内
 * 找出数组中任意一个重复的数字
 */
public class Duplicate01 {

    public void duplicate(int[] nums) {
        if (nums.length == 0 || nums == null)
            return;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (nums[i] != nums[nums[i]]) {
                    swap(nums, i, nums[i]);
                } else {
                    System.out.println(nums[i]);
                    break;
                }

            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
