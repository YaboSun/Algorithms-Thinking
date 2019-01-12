package mooc04.heap;

import mooc04.utils.SortTestHelper;

/**
 * @author YaboSun
 */
public class IndexMaxHeap {
    private int[] data;
    private int[] indexes;

    private int[] reverse; // 索引堆优化

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

    public int[] getIndexes() {
        return indexes;
    }

    public void setIndexes(int[] indexes) {
        this.indexes = indexes;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // 初始化最大堆
    public IndexMaxHeap(int capacity) {
        this.capacity = capacity;
        // 这里需要注意设计时下标从1开始
        // 所以要开辟capacity + 1大小的数组
        data = new int[capacity + 1];

        reverse = new int[capacity + 1];

        indexes = new int[capacity + 1];
        count = 0;
    }

    public IndexMaxHeap(int[] arr, int n) {
        data = new int[n + 1];
        indexes = new int[n + 1];
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
     * @param i 插入元素的索引 对于用户而言是从0索引的
     * @param e 要添加的元素
     */
    public void insert(int i, int e) {
        // TODO 这里只是简单的判断如果容量不足就返回，
        //  可以改进的是实现动态申请开辟新的空间
        if (count + 1 < capacity && i + 1 <= capacity) {
            i += 1;
            data[i] = e;
            indexes[count + 1] = i;
            reverse[i] = count + 1;
            count++;
            shiftUp(count);
        }
    }

    /**
     * 将索引为i的元素向上移动构成最大堆
     * @param i 要移动元素的索引下标
     */
    private void shiftUp(int i) {
        while (i > 1 && data[indexes[i / 2]] < data[indexes[i]]) {
            SortTestHelper.swap(indexes, i / 2, i);
            reverse[indexes[i / 2]] = i / 2;
            reverse[indexes[i]] = i;
            i /= 2;
        }
    }

    /**
     * 得到最大值
     * @return
     */
    public int extractMax() {
        int ret = data[indexes[1]]; // 这地方根据之前存的从下标1开始
        if (count > 0) {
            SortTestHelper.swap(indexes, 1, count);
            reverse[indexes[1]] = 1;
            reverse[indexes[count]] = 0; // 对于reverse来说是从1索引开始，所以将其删除实际上就是将其置为0
            count--;
            shiftDown(1);
        }
        return ret;
    }

    /**
     * 得到最大值的索引
     * @return
     */
    public int extractMaxIndex() {
        int ret = indexes[1] - 1; // 这地方根据之前存的从下标1开始
        if (count > 0) {
            SortTestHelper.swap(indexes, 1, count);
            reverse[indexes[1]] = 1;
            reverse[indexes[count]] = 0; // 对于reverse来说是从1索引开始，所以将其删除实际上就是将其置为0
            count--;
            shiftDown(1);
        }
        return ret;
    }

    /**
     * 给定一个索引获得对应元素
     * @param i
     * @return
     */
    public int getItem(int i) {
        // 对于用户输入的索引 需要判断其合法性
        assert (contain(i));
        return data[i + 1];
    }

    /**
     * 通过索引i将其data修改为新的item
     * @param i
     * @param item
     */
    public void change(int i, int item) {
        // 对于用户输入的索引 需要判断其合法性
        assert (contain(i));
        i += 1;
        data[i] = item;

        // 第一种实现 时间复杂度为O(n)
        // 找到indexes[j] = i,j表示data[i]在堆中的位置
        // 之后进行shiftUp(j)、shiftDown(j)
        /*for (int j = 1; j <= count; ++j) {
            if (indexes[j] == i) {
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }*/

        // 第二种实现 时间复杂度为O(nlogn)
        int j = reverse[i];
        shiftUp(j);
        shiftDown(j);
    }

    private boolean contain(int i) {
        return reverse[i + 1] != 0;
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
            if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]]) { // 说明有右孩子
                j += 1;
            }
            if (data[indexes[k]] >= data[indexes[j]]) {
                break;
            }
            SortTestHelper.swap(indexes, k, j);
            reverse[indexes[k]] = k;
            reverse[indexes[j]] = j;
            k = j;
        }
    }
}
