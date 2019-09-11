import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author YBSun
 * Created in 2019-05-05
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 */
public class MaxInWindows64 {
    public ArrayList<Integer> maxInWindows1(int [] num, int size) {

        // 定义最大值数组
        ArrayList<Integer> maxNumList = new ArrayList<>();

        if (size == 0)
            return maxNumList;
        int len = num.length;
        int i = 0;
        int j = i + size - 1;
        while (i < len - size) {
            int maxNum = calMaxNum(num, i++, j++);
            maxNumList.add(maxNum);
        }

        return maxNumList;
    }

    /**
     * 计算每个窗口中的最大值
     * @param num 当前窗口数组
     * @param i 数组最左下标
     * @param j 数组最右下标
     * @return maxNum 数组最大值
     */
    private int calMaxNum(int[] num, int i, int j) {
        int maxNum = 0;
        while (i <= j) {
            int temp = Math.max(num[i++], num[j--]);
            maxNum = Math.max(temp, maxNum);
        }
        return maxNum;
    }

    /**
     * 大佬解法，使用大顶堆
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }

}
