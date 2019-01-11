package doublepointer;

import java.util.List;

/**
 * @author YaboSun
 *
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output:
 * "apple"
 *
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * Output:
 * "a"
 * 题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，
 * 找出 能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最大字符串
 */
public class LeetCode524 {
    public String findLongestWord1(String s, List<String> d) {
        String longest = "";
        // 遍历字典中的单词
        for (String dicWord : d) {
            int i = 0;
            // 遍历给定字符串中是否有和单词匹配的
            for (char c : s.toCharArray()) {
                if (i < dicWord.length() && c == dicWord.charAt(i)) { // 遍历字典并比较s中的字符与字典中某一单词的索引i是否相同
                    i++;
                }
            }
            // 得到最大长度
            if (i == dicWord.length() && dicWord.length() >= longest.length()) {
                if (dicWord.length() > longest.length() || dicWord.compareTo(longest) < 0) {
                    longest = dicWord;
                }
            }
        }
        return longest;
    }

    // -----------------------------------另外一种解法 思想和notebook相似-----------------------------------------------------------
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for(String w: d){
            if(isSubsequence(w, s)){
                if(w.length() > res.length()) res = w;
                if(w.length() == res.length() && w.compareTo(res) < 0) res = w;
            }
        }
        return res;
    }

    private boolean isSubsequence(String w, String s){
        char[] wc = w.toCharArray();
        char[] sc = s.toCharArray();
        int i = 0, j = 0;
        while(i < wc.length && j < sc.length){
            if(wc[i] == sc[j]) i++;
            j++;
        }
        return i == wc.length;
    }
}
