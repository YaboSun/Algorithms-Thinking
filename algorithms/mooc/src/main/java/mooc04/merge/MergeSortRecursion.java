package mooc04.merge;

/**
 * @author YaboSun
 * @since Created in 18-10-18
 *
 * 归并排序--自顶向下的归并排序 即递归实现
 */
public class MergeSortRecursion {
    /**
     * 排序主算法
     * @param a 待排序数组
     * @param low 数组最左边界
     * @param high 数组最右边界
     * @return 返回排序数组
     */
    public int[] sort(int[] a, int low, int high){
        int mid = (low + high)/2;
        if(low < high){
            sort(a, low, mid);
            sort(a, mid+1, high);
            // 左右归并
            // 9.27改进，添加了一个判断，对于近乎有序的数组性能提升很多
            if (a[mid] > a[mid + 1]) {
                merge(a, low, mid, high);
            }
        }
        return a;
    }

    /**
     * 归并过程
     * @param a 待排序数组
     * @param low 数组最左边界
     * @param mid 每次归并中间元素下标
     * @param high 数组最右边界
     */
    public void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while(i <= mid && j <= high){
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i <= mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j <= high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x = 0; x < temp.length; x++){
            a[x + low] = temp[x];
        }
    }
}
