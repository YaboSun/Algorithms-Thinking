package mooc04.heap;

import mooc03.utils.SortTestHelper;

/**
 * @author YaboSun
 *
 * 最大堆实现
 */
public class MaxHeap {
    private int[] data;
    private int capacity;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // 初始化最大堆
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        // 这里需要注意设计时下标从1开始
        // 所以要开辟capacity + 1大小的数组
        data = new int[capacity + 1];
        count = 0;
    }

    public MaxHeap(int[] arr, int n) {
        data = new int[n + 1];
        this.capacity = n;
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;

        // 这里需要注意的是对于完全二叉树，第一个不是叶子结点的
        // 下标一定是满足i = count / 2
        for (int i = count / 2; i >= 1; --i) {
            shiftDown(i);
        }
    }

    /**
     * 得到最大堆的元素个数
     * @return count
     */
    public int size() {
        return count;
    }

    /**
     * 判断堆是否为空
     * @return false if empty
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 向最大堆中添加元素
     * @param n 要添加的元素
     */
    public void insert(int n) {
        // TODO 这里只是简单的判断如果容量不足就返回，
        //  可以改进的是实现动态申请开辟新的空间
        if (count + 1 < capacity) {
            data[++count] = n;
            shiftUp(count);
        }
    }

    /**
     * 将索引为i的元素向上移动构成最大堆
     * @param i 要移动元素的索引下标
     */
    private void shiftUp(int i) {
        while (i > 1 && data[i / 2] < data[i]) {
            SortTestHelper.swap(data, i / 2, i);
            i /= 2;
        }
    }

    public int extractMax() {
        int ret = data[1]; // 这地方根据之前存的从下标1开始
        if (count > 0) {
            SortTestHelper.swap(data, 1, count);
            count--;
            shiftDown(1);
        }
        return ret;
    }

    private void shiftDown(int k) {
        // 首先判断结点有孩子结点
        // 在完全二叉树中只要有左孩子就说明有孩子结点
        // 通过上面的分析知道左孩子和第一个结点满足2倍的关系
        // 所以判断条件为2*k <= count(当前结点个数)
        while (2 * k <= count) {
            // 需要比较左右孩子大小
            // 首要判断的边界条件就是有可能没有右孩子
            int j = 2 * k; // 定义左孩子
            if (j + 1 <= count && data[j + 1] > data[j]) { // 说明有右孩子
                j += 1;
            }
            if (data[k] >= data[j]) {
                break;
            }
            SortTestHelper.swap(data, k, j);
            k = j;
        }
    }
}
