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

    //
    public String PrintMinNumber1(int [] numbers) {
        int n;
        String s = "";
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
            s += j;
        }

        return s;
    }
}
