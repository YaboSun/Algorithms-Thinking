package doublepointer;

/**
 * @author YaboSun
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 题目描述： 在有序数组中找出两个数， 使它们的和为 target
 *
 * 自己实现 双指针
 */
public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        /*int[] index = {0, 0};
        int index1 = 0;
        int index2 = 0;
        for (; index1 < numbers.length; index1++) {
            for (index2 = index1 + 1; index2 < numbers.length; index2++) {
                if (numbers[index1] + numbers[index2] == target) {
                    index[0] = ++index1;
                    index[1] = ++index2;
                    break;
                } else if (numbers[index1] + numbers[index2] > target) {
                    break;
                }
            }
        }
        return index;*/

        // --------------------discuss解法----------------------------------
        for (int i = 0, j = numbers.length - 1; i < j;) {
            while (numbers[i] + numbers[j] < target) {
                i++;
            }
            while (numbers[i] + numbers[j] > target) {
                j--;
            }
            if (numbers[i] + numbers[j] == target) {
                int[] r = { i + 1, j + 1 };
                return r;
            }
        }
        return null;
    }
}
