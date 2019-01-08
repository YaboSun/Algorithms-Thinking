package heap;

import utils.SortTestHelper;

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
}
