package cyc;

/**
 * @author transwarp
 */
public class Duplicate03 {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    //                     [2,1,3,1,4]
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (length <= 0 || numbers == null)
            return false;
        int i = 0;
        while (i < length) {
            if (numbers[i] != i) {
                if (numbers[i] != numbers[numbers[i]]) {
                    swap(numbers, i, numbers[i]);
                } else {
                    duplication[0] = numbers[i];
                    return true;
                }
            } else {
                i++;
            }
        }
        return false;
    }

    private void swap(int[] numbers, int i, int number) {
        int temp = numbers[i];
        numbers[i] = numbers[number];
        numbers[number] = temp;
    }


    /**
     * cyc代码 知道思路 但是细节实现还是值得学习啊
     * @param nums
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicateCyC(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }
}
