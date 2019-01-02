package quick;

import common.SortTestHelper;
import insertion.InsertionSort;

/**
 * @author YaboSun
 * @since Created in 18-10-18
 * 三路快速排序
 * 是对于有大量重复元素的一个算法改进优化
 * 算法的思想简单来说就是将数组最终划分为大于,小于以及等于v的三个部分
 * 之后递归对于>v以及<v俩部分进行快速排序
 */
public class QuickSortThreeWays {
    InsertionSort insertionSort = new InsertionSort();

    /**
     * 通过递归调用来实现排序
     * @param arr 待排序数组
     * @param n 数组元素个数
     */
    public void quickSortThreeWays(int[] arr, int n) {
        quickSort3Ways(arr, 0, n - 1);
    }

    public void quickSort3Ways(int[] arr, int l, int r) {
        /**
         * 创建一个随机种子，来随机获取一个位置做为标准元素
         */
        int randomIndex = (int)(Math.random()*(r - l + 1) + l);

        /**
         * 做一个简单的优化，当数据小于16时直接调用插入排序会获得更好的效率
         */
        if (r - l <= 15) {
            insertionSort.insertionSort(arr, r - l + 1);
            return;
        }

        /**
         * 将随机位置的元素和第一个元素交换
         */
        SortTestHelper.swap(arr, l, randomIndex);

        /**
         * 定义标准元素
         */
        int v = arr[l];
        /**
         * 定义小于v的元素使得arr[l + 1...lt] < v
         * 其中lt是less than的缩写
         */
        int lt = l;
        /**
         * 定义大于v的元素使得arr[gt...r] > v
         * 其中gt是greater than的缩写
         */
        int gt = r + 1;
        /**
         * 定义等于v的区间，使得arr[lt + 1...i) == v
         */
        int i = l + 1;

        while (i < gt) {
            if (arr[i] < v) {
                SortTestHelper.swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i] > v) {
                SortTestHelper.swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }

        SortTestHelper.swap(arr, l, lt);

        quickSort3Ways(arr, l, lt - 1);
        quickSort3Ways(arr, gt, r);
    }
}

