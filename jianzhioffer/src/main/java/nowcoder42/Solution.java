package nowcoder42;

/**
 * @author YaboSun
 *
 * 将给定字符串循环左移 n 位输出
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str.length() <= 1) return str;
        int m = str.length() - n % str.length();

        char[] chars1 = str.toCharArray();
        char[] chars2 = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            chars2[(i + m) % str.length()] = chars1[i];
        }
        return new String(chars2);
    }
}
