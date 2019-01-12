package mooc04.quick;

/**
 * @author YaboSun
 * @since Created in 18-10-18
 */

import mooc04.utils.SortTestHelper;

/**
 * Created by hadoop on 18-10-6
 *
 * 通过之前的代码编写可以发现，如果对于近似有序的数组进行排序
 * 排序时间非常久，因为如果是近似有序的数组对于快速排序来说最后构建的相当于一颗完全不平衡的二叉树
 * 导致最终的时间复杂度近乎为O(n^2)
 * 为了解决这个问题，可以通过将标准元素随机获取的方法来改进，那么通过数学知识可以知道 改进的算法时间复杂度为nlogn
 */
public class QuickSortOptimize {
    public QuickSortOptimize(int[] arr, int n) {
        improvedQuickSort(arr, 0, n - 1);
    }

    /**
     * 对arr[l...r]部分进行快速排序
     * @param arr 待排序数组
     * @param l 数组左边界
     * @param r 数组右边界
     */
    public void improvedQuickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        improvedQuickSort(arr, l, p - 1);
        improvedQuickSort(arr, p + 1, r);
    }

    /**
     * 对arr[l...r]部分进行partition操作
     * @param arr 传入数组
     * @param l 数组左边界
     * @param r 数组右边界
     * @return j 返回索引j，使得arr[l...j-1] < arr[j];arr[j+1...r] > arr[j]
     */
    public int partition(int[] arr, int l, int r) {
        /**
         * 定义随即选取数组的一个元素为标准元素
         */
        int randomIndex = (int)(Math.random()*((r - l + 1) + l));
        int v = arr[randomIndex];
        /**
         * 定义一个索引下标j使满足
         * arr[l + 1...j] < v ; arr[j+1...i]>v
         */
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                SortTestHelper.swap(arr, j + 1, i);
                j++;
            }
        }
        SortTestHelper.swap(arr, l, j);
        return j;
    }
}