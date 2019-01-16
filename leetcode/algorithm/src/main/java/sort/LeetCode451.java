package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YBSun
 * Created in 2019-01-14
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * 题目描述：按照字符出现次数对字符串排序
 */
public class LeetCode451 {

    // 实现思路：
    //
    public String frequencySort1(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char c : s.toCharArray()) {
            // 构建map，其key是对应的字符
            // value是出现的次数
            // 这里注意get() 返回到指定键所映射的值，或 null如果此映射包含该键的映射
            // getDefaultValue 返回到指定键所映射的值，或 defaultValue如果此映射包含该键的映射
            // 使用getDefaultValue可以实现如果map中不包含该键，就设置为默认值0 再+ 1
            // 如果包含就获得当前的值并 + 1
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        }
        // 这个关键是要理解这个桶的设计
        // 后面按照value的值来放置对应的位置，这样就可以保证从后往前一定是从大到小的顺序
        // 而且开辟的是一个ArrayList可以满足这样的要求，出现多少次就在后面append多少次 最后进行输出
        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c : frequencyForNum.keySet()) {
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) { // 遍历有多少个字母就输出多少个
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }
}
