package mooc04.merge;

/**
 * @author YaboSun
 *
 * 使用泛型实现MergeSort
 * 是归并排序的最终版
 * 参考《算法设计与分析》--归并排序
 */
public class GenericMergeSort {

    /**
     * 通过一个内部方法来实现递归调用
     * @param arr 待排序数组
     * @param tmpArr 用于存放排序后数组
     * @param left 子数组最左边的索引下标
     * @param right 子数组最右索引下标
     */
    private static void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, tmpArr, left, center);
            mergeSort(arr, tmpArr, center + 1, right);
            merge(arr, tmpArr, left, center + 1, right);
        }
    }

    /**
     * 归并排序算法
     * 实现对外只提供一个接口
     * @param arr 待排序数组
     */
    public static void mergeSort(int[] arr) {
        int[] tmpArr = new int[arr.length];

        mergeSort(arr, tmpArr, 0, arr.length - 1);
    }

    /**
     * 归并核心代码
     * @param arr 待归并数组
     * @param tmpArr 归并后数组
     * @param leftPos 左半部分数组起始下标
     * @param rightPos 右半部分数组起始下标
     * @param rightEnd 右半部分数组结束下标
     */
    private static void merge(int[] arr, int[] tmpArr, int leftPos, int rightPos, int rightEnd) {
        // 定义左半部分数组结束下标
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] <= arr[rightPos]) {
                tmpArr[tmpPos++] = arr[leftPos++];
            } else {
                tmpArr[tmpPos++] = arr[rightPos++];
            }
        }

        while (leftPos < leftEnd) {
            tmpArr[tmpPos++] = arr[leftPos++];
        }

        while (rightPos < rightEnd) {
            tmpArr[tmpPos++] = arr[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            arr[rightEnd] = tmpArr[rightEnd];
        }
    }
}
