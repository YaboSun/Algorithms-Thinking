package easy.leetcode674;

/**
 * @author YaboSun
 *
 * Given an unsorted array of integers,
 * find the length of longest continuous increasing subsequence (subarray).
 *
 * 给定一个数组 找到连续增加的最长子数组长度
 * [1,3,5,4,7] 3
 * [2,2,2,2,2] 1
 */
public class SolutionOne {

    /**
     * 初步想法：
     * 遍历整个数组，如果连续增加 记录最左边界left直到出现下降记录最右边界right
     * 子数组的长度应为len = right - left + 1
     * 继续遍历 找到下一个连续增加的子数组 并比较这俩个大小
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int left = 0;
        int len = 0;
        int maxLen = 1;

        if (nums.length <= 1) {
            return nums.length;
        }
        for (int right = left + 1; right < nums.length; right++) {
            if (nums[right] > nums[right - 1]) {
                len = right - left + 1;
            } else if (nums[right] <= nums[right - 1]) {
                left = right;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
