package nowcoder34;

import java.util.LinkedHashMap;

/**
 * @author YaboSun
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 */
public class Solution {

    public int FirstNotRepeatingChar(String str) {

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) { // 如果在map中已经包含了该字符
                int time = map.get(str.charAt(i)); // 获得出现的次数
                map.put(str.charAt(i), ++time); // 将对应的字符放入 并将原有的次数++
            }
            else {
                map.put(str.charAt(i), 1); // 如果之前没有出现过 将对应的键放入 并将其出现的次数记为1
            }
        }

        int i = 0;
        for (; i < str.length(); i++) { // 遍历字符串
            char c = str.charAt(i);
            if (map.get(c) == 1) { // 如果第一个出现1次就直接返回对应的下标i
                return i;
            }
        }

        return -1;
    }
}
