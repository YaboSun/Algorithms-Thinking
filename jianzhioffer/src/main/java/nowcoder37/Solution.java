package nowcoder37;

/**
 * @author YaboSun
 *
 * 统计一个数字在排序数组中出现的次数
 */
public class Solution {

    // 知识迁移，结合二分法找到第一个出现k的位置以及最后一个出现k的位置
    // 对应的下标相减就是要的结果
    public int GetNumberOfK(int [] array , int k) {
        int number = 0;
        int firstIndex = getFirstKey(array, k, 0, array.length - 1);
        int lastIndex = getLastKey(array, array.length, k, 0, array.length - 1);

        if (firstIndex > -1 && lastIndex > -1) {
            number = lastIndex - firstIndex + 1;
        }

        return number;
    }

    private int getFirstKey(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        if (middleData == k) {
            // 中间数正好为k，判断是否是第一个出现k的位置
            // 如果是第一个那么前面下标应该不为k
            if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }

        return getFirstKey(array, k, start, end);
    }

    private int getLastKey(int[] array, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        if (middleData == k) {
            if ((middleIndex < length - 1 && array[middleIndex + 1] != k) || middleIndex == length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }

        return getLastKey(array, length, k, start, end);
    }
}
