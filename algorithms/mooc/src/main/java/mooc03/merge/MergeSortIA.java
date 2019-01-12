package mooc03.merge;

/**
 * @author YaboSun
 *
 * 按照算法导论中伪代码自己实现
 * IA为Introduction Algorithms字母简写
 * 主要的步骤就是：
 * 1、将数组分为俩部分
 * 2、递归将前半部分递归排序
 * 3、递归将后半部分递归排序
 * 4、将俩部分合并
 * 所以核心部分就是合并的部分
 *
 */
public class MergeSortIA {

    /**
     * 使用递归方式归并排序
     * @param arr 待排序数组
     * @param l left 数组左边界
     * @param r right 数组右边界
     */
    public void mergeSortIA(int[] arr, int l, int r) {

        int mid = (l + r)/2;
        mergeSortIA(arr, l, mid);
        mergeSortIA(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public void merge(int[] arr, int l, int mid, int r) {

    }
}
