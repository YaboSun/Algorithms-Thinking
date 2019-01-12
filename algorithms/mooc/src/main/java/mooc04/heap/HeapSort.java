package mooc04.heap;

import mooc04.utils.SortTestHelper;

/**
 * @author YaboSun
 *
 * 堆排序几种实现方法
 * 前俩种实现都是新开辟一个堆空间进行操作，空间复杂度为O(n)
 * 并且前面都是从1开始进行索引，对于第一个元素不适用
 * 第三种实现是原地算法，整个空间复杂度是O(1)，
 * 而因为是直接在原数组上进行操作，所以从0开始索引
 * 同样可以得到左右孩子的表示方法分别为left child = 2*i + 1
 * right child = 2*i + 2，同样最后一个非叶子节点的索引也变为(count - 1)/2
 */
public class HeapSort {

    /**
     * 堆排序第一个版本实现
     * @param arr 待排序数组
     * @param n 堆元素个数
     */
    public void heapSortOne(int[] arr, int n) {
        MaxHeap maxHeap = new MaxHeap(n);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(i);
        }
        for (int i = n - 1; i >= 0; --i) {
            arr[i] = maxHeap.extractMax();
        }
    }

    /**
     * 堆排序第二个版本实现
     *
     * 对比第一种逐个插入的方式其算法复杂度是O(nlogn) 采用从count / 2位置开始实现
     * 这样的算法复杂度为O(n) heapify方式
     * @param arr 待排序数组
     * @param n 堆元素个数
     */
    public void heapSortTwo(int[] arr, int n) {
        MaxHeap maxHeap = new MaxHeap(arr, n);

        for (int i = n - 1; i >= 0; --i) {
            arr[i] = maxHeap.extractMax();
        }
    }

    /**
     * 堆排序最优实现
     * @param arr
     * @param n
     */
    public void heapSort(int[] arr, int n) {
        for (int i = (n - 1)/2; i >= 0; --i) { // 索引从0开始
            shiftDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; --i) {
            SortTestHelper.swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    /**
     * 原地堆排序shiftDown实现
     * 与maxHeap中的很相似，只不过开始下标为0
     * @param arr
     * @param n
     * @param k
     */
    private void shiftDown(int[] arr, int n, int k) {
        // 首先判断结点有孩子结点
        // 在完全二叉树中只要有左孩子就说明有孩子结点
        // 通过上面的分析知道左孩子和第一个结点满足2*i + 1的关系
        // 所以判断条件为2*k + 1<= count(当前结点个数)
        while (2 * k + 1 < n) {
            // 需要比较左右孩子大小
            // 首要判断的边界条件就是有可能没有右孩子
            int j = 2 * k + 1; // 定义左孩子
            if (j + 1 < n && arr[j + 1] > arr[j]) { // 说明有右孩子
                j += 1;
            }
            if (arr[k] >= arr[j]) {
                break;
            }
            SortTestHelper.swap(arr, k, j);
            k = j;
        }
    }
}
