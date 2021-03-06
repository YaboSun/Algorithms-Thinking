package nowcoder32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author YaboSun
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字 中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 */
public class Solution {

    //可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，
    // 应该比较的是 S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，
    // 那么应该把 S1 排在前面，否则 应该把 S2 排在前面
    public String PrintMinNumber1(int [] numbers) {
        int n;
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });

        for (int j : list) {
            s.append(j);
        }

        return s.toString();
    }
}
