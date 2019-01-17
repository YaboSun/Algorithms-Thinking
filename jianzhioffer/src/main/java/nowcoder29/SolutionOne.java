package nowcoder29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YaboSun
 *
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 */
public class SolutionOne {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        List<Integer> minNums = new ArrayList<>();
        if (k <= input.length) {
            Arrays.sort(input);
            for (int i = 0; i < k; i++) {
                minNums.add(input[i]);
            }
        }
        return (ArrayList<Integer>) minNums;
    }
}
