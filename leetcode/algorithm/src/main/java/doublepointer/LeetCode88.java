package doublepointer;

/**
 * @author YaboSun
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 *
 * 题目描述：将两个有序数组合并成一个有序数组
 *
 * 思路 从后往前进行归并
 */
public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int temp = i + j + 1;

        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[temp--] = nums2[j];
                j--;
            } else if (j < 0) {
                nums1[temp--] = nums1[i];
                i--;
            } else if (nums2[j] >= nums1[i]) {
                nums1[temp--] = nums2[j];
                j--;
            } else {
                nums1[temp--] = nums1[i];
                i--;
            }
        }
    }
}
