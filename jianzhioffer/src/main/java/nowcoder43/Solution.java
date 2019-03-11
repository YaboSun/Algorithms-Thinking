package nowcoder43;

/**
 * @author YaboSun
 *
 * 字符串翻转
 */
public class Solution {
    // 解法一：
    // 直接按照“ ”进行划分字符串
    // 然后首尾交换，最后进行拼接，但是最后只有60%
    public String ReverseSentence1(String str) {
        if (str.equals(""))
            return str;
        if (str.equals(" "))
            return str + " ";
        String[] strings = str.split(" ");

        reverse(strings, 0, strings.length - 1);

        StringBuffer s = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            if (i == strings.length - 1) {
                s.append(strings[i]);
            } else {
                s.append(strings[i]).append(" ");
            }
        }

        System.out.println(s);
        return s.toString();

    }

    private void reverse(String[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(String[] strings, int i, int j) {
        String tmp = strings[i];
        strings[i] = strings[j];
        strings[j] = tmp;
    }

    /**
     * 解法二：
     * 这个解法其实是最开始想到的，但是没有实现，就换了
     * 题目应该有一个隐含条件，就是不能用额外的空间
     * 思路就是先旋转每个单词，再旋转整个字符串
     */
    public String ReverseSentence2(String str) {
        int len = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;

        while (j <= len) {
            if (j == len || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, len - 1);
        String s = new String(chars);
        System.out.println(s);
        return s;
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

}