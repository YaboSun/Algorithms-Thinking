/**
 * @author YaboSun
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2
 */
public class FirstDuplicate49 {
    // 初步思路
    // 找到数组中最大的数 max，开辟一个 max + 1 大小的数组
    // 遍历数组，将对应的数组设置为1，如果当前值已经为1，那么就是第一个出现重复的值
    // 可以实现结果 但是与要求好像不太符 题目要求应该是不能使用额外空间
    public boolean duplicate(int numbers[], int length, int [] duplication) {
        int max = 0;
        int ret = 0;
        for (int i = 0; i < length; i++)
            max = Math.max(max, numbers[i]);

        int[] flag = new int[max + 1];

        for (int i : numbers) {
            if (flag[i] == 1) {
                ret = i;
                break;
            } else {
                flag[i] = 1;
            }
        }
        return duplication[0] == ret;
    }

    public boolean duplicate2(int numbers[], int length, int [] duplication) {

        if (numbers == null || length < 1)
            return false;
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
