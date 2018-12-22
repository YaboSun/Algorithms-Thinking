package common;

/**
 * @author YaboSun
 * @since Created in 18-10-18
 *
 * 辅助排序，主要是解决硬编码生成数组的问题
 * 如果后面比较算法的效率，可能需要的测试数组有成千上万个数，所以需要随机生成
 */
public interface SortTestHelper {

    /**
     * 生成有n个元素的随机数组
     * 每个元素的随机范围是[rangeL, rangeR]
     * @param n 数组元素个数
     * @param rangeL 数组左边界
     * @param rangeR 数组右边界
     * @return 返回生成的数组
     */
    static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        // 判断要满足左边小于右边
        assert(rangeL <= rangeR);
        // 创建一个大小为n的数组
        int[] arr = new int[n];
        // 生成随机数
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    /**
     * 生成有n个元素的几乎排好序的数组
     * @param n 数组元素个数
     * @param swapTimes 俩俩交换次数
     * @return 生成的几乎排好序的数组
     */
    static int[] generateNearlyOrderedArray(int n, int swapTimes) {
        /**
         * 开辟一个数组空间
         */
        int[] arr = new int[n];

        // 先生成一个完全有序的数组
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        // 接下来随机挑选几对数进行交换
        for (int i = 0; i < swapTimes; i++) {
            int posx = (int)(Math.random() * n);
            int posy = (int)(Math.random() * n);
            swap(arr, posx, posy);
        }

        return arr;
    }

    /**
     * 用于打印数组内容
     * @param arr 传入的数组
     */
    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------");
    }

    /**
     * 用于计算不同排序算法所用的时间
     */
    void calculateSortTime();

    /**
     * 判断数组是否排序成功
     */
    static boolean isSorted(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 交换数组中的俩个数
     * @param arr 数组
     * @param i 第一个数组元素下标
     * @param j 第二个数组元素下标
     */
    static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static int[] copyIntArray(int[] arr, int n) {
        int[] newArr = new int[n];
        /**
         * 数组拷贝的几种方式
         *
         * 第一种 System.arraycopy 参数分别表示：原数组、原数组的开始位置、新数组、新数组的开始位置
         * 第二种 Arrays.copyOf 参数分别表示：原数组，拷贝的个数
         * 第三种 Arrays.copyOfRange 参数分别表示：原数组，开始位置，拷贝的个数
         */
        System.arraycopy(arr, 0, newArr, 0, n);
        /*newArr = Arrays.copyOf(arr, n);
        newArr = Arrays.copyOfRange(arr, 0, n);*/

        return newArr;
    }

}
