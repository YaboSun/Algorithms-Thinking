package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author YaboSun
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 题目描述：找到无序数组中第k个最大值
 */
public class LeetCode215 {
    /**
     * 使用系统自带将给定数组排序 倒数第k个就是所求
     * 时间复杂度O(nlogn) 空间复杂度O(1)
     * @param nums 给定数组
     * @param k 第k个
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 通过一个大小始终为k的优先队列来实现，对于优先队列是有序的而且
     * 优先队列头是最小元素 所以队列尾是第k大元素
     * 时间复杂度为O(nlogk) 空间复杂度为O(k)开辟空间为k的优先队列
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll(); // 维护队列的大小始终为k 当超过k时检索队列头并删除
            }
        }
        return pq.peek(); // 检索队列头不删除 并返回队列头对应的元素
    }

    /**
     * 选择快速排序结合
     * 最好情况时间复杂度为O(n) 最坏为O(n^2)空间复杂度为O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k; // 设置第k个 后面排好序直接输出
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (nums[++i] < nums[l] && i < h);
            while (nums[--j] > nums[l] && j > l);
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
