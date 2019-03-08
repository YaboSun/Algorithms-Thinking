package nowcoder40;

import java.util.ArrayList;

/**
 * @author YaboSun
 *
 * 题目描述：
 * 输出所有和为sum的连续子序列
 */
public class Solution {

    // 第一种实现：通过率只有50%
    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int temp = 1;
        for (int i = 1; i < sum; i++) {
            for (int j = i + 1; j < sum; j++) {
                temp += j;
                if (temp == sum) {
                    for (int m = i; m <= j; m++) {
                        list.add(m);
                    }
                    lists.add(list);
                    temp -= i;
                    break;
                }
            }
        }
        return lists;
    }

    // 第二种解法：思路大致相同，但是细节考虑很好，变量命名以及代码逻辑很清晰
    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum > sum) {
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                end++;
                curSum += end;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                ret.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }
}
