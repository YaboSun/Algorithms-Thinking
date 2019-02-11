package nowcoder35;

/**
 * @author YBSun
 * Created in 2019-02-11
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 *
 * 题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 * 	对于%50的数据,size<=10^4
 * 	对于%75的数据,size<=10^5
 * 	对于%100的数据,size<=2*10^5
 */
public class Solution {

    private long cnt = 0;
    private int[] tmp;
    // 解决思路1：
    // 通过归并排序实现，因为在归并排序时候如果
    public int InversePairs1(int [] array) {
        tmp = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] array, int l, int h) {
        if (h - l < 1) {
            return;
        }
        int m = l + (h - l) / 2;
        mergeSort(array, l, m);
        mergeSort(array, m + 1, h);
        merge(array, l, m, h);
    }

    private void merge(int[] array, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m) {
                tmp[k] = array[j++];
            } else if (j > h) {
                tmp[k] = array[i++];
            } else if (array[i] < array[j]) {
                tmp[k] = array[i++];
            } else {
                tmp[k] = array[j++];
                this.cnt += m - i + 1;
            }
            k++;
        }
        for (k = l; k <= h; k++) {
            array[k] = tmp[k];
        }
    }
}
