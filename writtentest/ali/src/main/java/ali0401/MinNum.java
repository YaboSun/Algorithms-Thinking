package ali0401;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YaboSun
 */
public class MinNum {

    public int getMinNum(String strNum, int k) {

        char[] chars = strNum.toCharArray();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }

        int count = 0;
        for (int i = 1; i < list.size(); i++) {

            if (count == k) {
                break;
            }
            if (i == list.size() - 1 && count < k) {
                for (int i1 = 0; i < chars.length - k; i++) {

                }
            }
            if (list.get(i) < list.get(i - 1)) {
                list.remove(i - 1);
                count++;
            }

        }
        return 0;
    }

    public int getMinNum2(String strNum, int k) {

        char[] chars = strNum.toCharArray();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }

        int len = chars.length;

        while (k-- >= 0) {
            int i = 0, j;

        }

        return 0;
    }
}
