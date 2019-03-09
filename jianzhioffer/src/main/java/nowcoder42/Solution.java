package nowcoder42;

/**
 * @author YaboSun
 *
 * 将给定字符串循环左移 n 位输出
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 */
public class Solution {
    // 解法一 直接开辟一个新的空间将循环左移的结果保存在其中
    public String LeftRotateString1(String str,int n) {
        if (str.length() <= 1) return str;
        int m = str.length() - n % str.length();

        char[] chars1 = str.toCharArray();
        char[] chars2 = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            chars2[(i + m) % str.length()] = chars1[i];
        }
        return new String(chars2);
    }

    /**
     * 解法二
     * 不开辟新的空间，先将“abc”和“XYZdef”分别翻转
     * 然后再把整个字符串翻转
     * @param str 要翻转的字符串
     * @param n 这里好像是用来表示要翻转的长度，方便使用递归
     * @return 翻转后的字符串
     */
    public String LeftRotateString2(String str,int n) {
        if (n >= str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j)
            swap(chars, i++, j--);
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
