package mooc04;

/**
 * @author YaboSun
 */
public class MinHeapTest {

    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            minHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将minheap中的数据逐渐使用extractMin取出来
        // 取出来的顺序应该是按照从小到大的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = minHeap.extractMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从小到大排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] <= arr[i];
    }
}