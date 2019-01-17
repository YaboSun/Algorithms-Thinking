package nowcoder28;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YaboSun
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class SolutionOne {
    public int MoreThanHalfNum_Solution(int [] array) {

        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : array) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }

        for (int i : frequencyForNum.keySet()) {
            int maxNum = frequencyForNum.get(i);
            if (maxNum > array.length / 2) {
                return i;
            }
        }
        return 0;
    }
}
