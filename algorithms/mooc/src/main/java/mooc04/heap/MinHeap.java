package mooc04.heap;

/**
 * @author YaboSun
 *
 *
 */
// 在堆的有关操作需要比较堆中元素的大小 所以item需要继承Comparable
public class MinHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count; // 最小堆元素个数
    protected int capacity; // 最小堆的最大容量

    // 构造函数 构造一个空堆 可以容纳capacity个元素
    public MinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 构造函数 通过一个给定的数组创建一个最小堆
    // 该构造函数的过程时间复杂度为O(n)
    public MinHeap(Item[] arr) {

        int n = arr.length;
        data = (Item[]) new Comparable[n + 1];
        capacity = n;

        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;

        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 判断堆是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向最小堆中插入元素
    public void insert(Item item) {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    // 获得堆中的最小元素 即取出堆顶元素
    public Item extractMin() {
        assert count > 0;
        Item ret = data[1];

        swap(1, count);
        count--;
        shiftDown(1);

        return ret;
    }

    // 获取堆中最小元素
    public Item getMin() {
        assert count > 0;
        return data[1];
    }

    private void swap(int i, int j) {
        Item temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 最小堆核心辅助函数
     * @param k
     */
    private void shiftUp(int k) {
        // 如果当前所在的结点比其父亲结点值大 那么就交换两者
        while (k > 1 && data[k / 2].compareTo(data[k]) > 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    /**
     * 将当前结点下移使得满足最小堆
     * @param k
     */
    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k; // 此轮循环中 data[k]和data[j]交换位置
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) < 0) {
                j++;
            }
            if (data[k].compareTo(data[j]) <= 0) {
                break;
            }
            swap(k , j);
            k = j;
        }
    }
}
