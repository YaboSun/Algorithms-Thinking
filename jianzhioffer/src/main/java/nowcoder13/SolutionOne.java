package nowcoder13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YaboSun
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 暴力解法 不确定是否空间会超
 * 新开辟俩个arraylist存放奇数偶数
 * 全部遍历一遍 然后存放
 */
public class SolutionOne {
    public void reOrderArray(int[] array) {
        List<Integer> list1 = new ArrayList<>(); // 存放奇数
        List<Integer> list2 = new ArrayList<>(); // 存放偶数
        for (int i : array) {
            if ((i & 1) == 1) {
                list1.add(i);
            } else {
                list2.add(i);
            }
        }

        for (int i = 0; i < list1.size(); i++) {
            array[i] = list1.get(i);
        }
        int beginIndex = list1.size();
        for (int j = 0; j < list2.size(); j++) {
            array[beginIndex] = list2.get(j);
            beginIndex++;
        }
    }
}
