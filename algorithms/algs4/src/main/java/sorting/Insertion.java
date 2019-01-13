package sorting;

/**
 * @author YaboSun
 */
public class Insertion {

    /********************************************************
     *                      个人代码初步实现
     * ******************************************************/

    /**
     * 插入排序核心代码
     * 双指针进行遍历 每次找数组中最小的数，初始定义最小值为arr[0]
     * 后面依次比较，如果arr[j] < min就交换arr[i]和arr[j]
     * @param arr
     */
    public void mySort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Comparable min = arr[i];
                if (arr[j].compareTo(min) < 0) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /********************************************************
     *                      排序辅助函数
     * ******************************************************/

    // 交换a[i]和a[j]
    private void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
