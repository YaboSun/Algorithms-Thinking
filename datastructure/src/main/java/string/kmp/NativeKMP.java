package string.kmp;

/**
 * @author YaboSun
 */
public class NativeKMP {

    /**
     * 获取一个字符串的next数组
     * @param T 要查找的子串
     * @param next 子串的next数组
     */
    private void getNext(String T, int[] next) {
        int i = 0;
        int j = 0;
        while (i < T.length()) {
            if (j == 0 || T.indexOf(i) == T.indexOf(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    /**
     * 返回子串T在主串S中第pos个字符之后的位置
     * 若不存在则函数返回值为0
     * @param S 主串
     * @param T 子串
     * @param pos 子串在主串中位置
     * @return 返回位置
     */
    public int indexKMP(String S, String T, int pos) {

        // i用于主串S当前位置下标值，
        // 若pos不为1，则从pos位置开始匹配
        int i = pos;

        // j用于子串T中当前位置的下标值
        int j = 1;
        int[] next = new int[255];
        // 计算当前子串的next数组
        getNext(T, next);
        while (i < S.length() && j <= T.length()) {
            if (j == 0 || S.indexOf(i) == T.indexOf(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j > T.length()) {
            return i - T.length();
        } else {
            return 0;
        }
    }
}
