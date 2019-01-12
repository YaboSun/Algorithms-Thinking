package mooc04.merge;

/**
 * @author YaboSun
 * @since Created in 18-10-18
 *
 * 归并排序 按照视频中的有错
 * 正确的实现在mergesortTwo中实现
 */
public class MergeSort {
    /**
     * 通过私有函数将内部排序的原理进行封装，使用户只能调用接口进行使用
     * @param arr 传入的数组
     * @param n 数组的长度
     */
    public void mergeSort(int[] arr, int n) {
        mergeSort(arr, 0, n-1);
    }

    /**
     * 递归使用归并排序，对arr[l...r]的范围进行排序，需要注意的是左右都是闭
     * @param arr 待排序的数组
     * @param l 数组的第一个元素下标
     * @param r 数组的最后一个元素下标
     */
    private void mergeSort(int[] arr, int l, int r) {
        // 表示当前只剩下一个元素 或者没有元素
        if (l >= r) {
            return;
        }

        // 定义数组的中间位置
        int mid = (l + r)/2; // TODO 这里需要注意的是当l、r非常大时候，可能发生溢出的错误,如何解决

        // 通过递归对于分开的前后俩部分进行归并排序
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        // 进行merge
        merge(arr, l, mid, r);

    }

    /**
     * 将arr[l...mid]以及[mid + 1, r]俩部分进行归并
     * @param arr 待排序的数组
     * @param l 数组最左边界
     * @param mid 中间元素
     * @param r 数组嘴右元素
     */
    private void merge(int[] arr, int l, int mid, int r) {
        // 声明一个和arr大小相同的辅助数组
        int[] aux = new int[r - l + 1];

        // 将arr赋值给aux
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }

        // 创建俩个移动下标
        int i = l, j = mid + 1;

        // 进行遍历，每一次添加一个则k++，指导最终排序完成
        for (int k = 0; k <= r; k++) {
            // 先判断索引的合法性
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r){
                arr[k] = aux[i - l];
                i++;
            }
            // 如果索引合法，则开同时比较俩个子数组开头的部分
            else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
}