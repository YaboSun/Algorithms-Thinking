package doublepointer;

/**
 * @author YaboSun
 *
 * Input: "aba"
 * Output: True
 *
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 题目描述：最多删除一个字符判断是否能构成回文字符串
 */
public class LeetCode680 {
    public boolean validPalindrome(String s) {
        int i = -1;
        int j = s.length();
        while (++i < --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
