package nowcoder41;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author YaboSun
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，
 * 输出两个数的乘积最小的。
 */
public class Solution {

    // 思路：使用双指针，第一个指针从头到尾进行遍历
    // 第二个指针从尾到头进行遍历，如果tmp == sum,输出这两个数
    // 如果tmp > sum,大指针减小，反之小指针增加
    public ArrayList<Integer> FindNumbersWithSum1(int [] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();
        if (array.length == 1) return list;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > 0; j--) {
                int temp = array[i] + array[j];
                if (temp == sum) {
                    list.add(array[i]);
                    list.add(array[j]);
                    return list;
                }
                if (temp < sum) {
                    break;
                }
            }
        }
        return list;
    }


    // 代码改进 更简洁
    public ArrayList<Integer> FindNumbersWithSu2(int [] array, int sum) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];
            if (cur == sum) {
                return new ArrayList<>(Arrays.asList(array[i], array[j]));
            } else if (cur < sum) {
                i++;
            } else {
                j--;
            }
        }
        return new ArrayList<>();
    }
}
