package doublepointer;

import java.util.*;

/**
 * @author YaboSun
 *
 * Input: "hello"
 * Output: "holle"
 * Input: "leetcode"
 * Output: "leotcede"
 * 题目描述：反转字符串中的元音字母
 *
 * 元音字母 a e i o u
 * 初步思路：
 * 找到字符串中的元音字符 使用HashMap存储，
 * 其中key为其下标 value为字符值
 */
public class LeetCode345 {
    /*public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Map<Integer, String> stringMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' || chars[i] == 'e'
                    || chars[i] == 'i' || chars[i] == 'o'
                    || chars[i] == 'u') {
                stringMap.put(i, String.valueOf(chars[i]));
            }
        }
        Iterator<Integer> iterator = stringMap.keySet().iterator();
        List<Integer> vowIndex = new ArrayList<>();
        while (iterator.hasNext()) {
            vowIndex.add(iterator.next());
        }
        // 转化下标
        for (int i = 0, j = vowIndex.size() - 1; i <= j;) {

        }
        return new String(chars);
    }*/

    // 思路不足：1、元音字符大小写区分 2、可以直接判断是否包含字符利用字符串"aeiouAEIOU"

    // -------------------------------discuss-------------------------------------------

    public String reverseVowels1(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++)
        {
            if ("AEIOUaeiou".indexOf(s.charAt(i)) != -1)
            {
                while (j >= 0 && "AEIOUaeiou".indexOf(s.charAt(j)) == -1)
                {
                    j--;
                }
                sb.append(s.charAt(j));
                j--;
            }
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }


    // ----------------------------------------notebook--------------------------------------
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
