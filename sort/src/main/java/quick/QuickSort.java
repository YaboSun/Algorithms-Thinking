package quick;

/**
 * @author YaboSun
 * @since Created in 18-10-18
 */
public class QuickSort {

    /**
     * 切分数组，找到基准数值
     * @param nums 待排序数组
     * @param left 数组左边界
     * @param right 数组右边界
     * @return left
     */
    public int division(int[] nums, int left, int right) {
        // 以最左边的数（left）为基准
        int base = nums[left];
        while (left < right) {
            // 从数组右端开始遍历，直到找到比base小的数
            while (left < right && nums[right] >= base) {
                right--;
            }
            // 找到了比base小的元素，将这个元素放到最左边的位置
            nums[left] = nums[right];
            // 从数组左端开始遍历，直到找到比base大的数
            while (left < right && nums[left] <= base) {
                left++;
            }
            // 找到了比base大的元素，将这个元素放到最右边的位置
            nums[right] = nums[left];
        }
        // 最后将base放到left的位置，这时候left左边的数值应该都比left小
        // 而右边的数值应该都比left大
        nums[left] = base;
        return left;
    }

    /**
     * 进行排序
     * @param nums 待排序数组
     * @param left 数组左边界
     * @param right 数组右边界
     */
    public void quickSort(int[] nums, int left, int right) {
        // 左下标一定小于右下标
        if (left < right) {
            // 对数组进行分割，取出下次分割的基准标号
            int base = division(nums, left, right);
            // 对中间过程进行排序
            //System.out.format("base = %d:", nums[base]);
            //printPart(nums, left, right);

            // 对基准数值左侧进行递归排序，以至于将这些数值完整排序
            quickSort(nums, left, base - 1);

            // 对基准数值右侧进行递归排序，以至于将这些数值完整排序
            quickSort(nums, base + 1, right);
        }
    }

    /**
     * 打印中间数组
     * @param nums 待排序数组
     * @param begin 数组开始位置
     * @param end 数组最后位置
     */
    public void printPart(int[] nums, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print(" ");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }


}
