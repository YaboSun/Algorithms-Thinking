package cyc;

/**
 * @author transwarp
 * @date 19-5-25
 *
 * 将一个字符串中的空格替换成 "%20"
 *
 */
public class ReplaceSpace05 {

    /**
     * Input:
     * "A B"
     * Output:
     * "A%20B"
     *
     * 初步思路，首先遍历字符串，每次遍历到空格就在字符串后面追加2个空格
     * 之后从字符串最开始length开始往前遍历，如果遇到空格
     * 就在新字符串对应位置一次补0、2、%，否则就将对应位置替换为当前字母
     *
     * 第一次没有通过，strbuffer的函数使用有误，使用setChar可以直接设置
     * 第二次修改后通过
     * @param str 输入字符串
     * @return 替换后字符串
     */
    public String replaceSpace(StringBuffer str) {

        /** 保存原始字符串长度 */
        int len = str.length();

        if (len == 0 || str == null) {
            return str.toString();
        }

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int j = str.length() - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
            } else {
                str.setCharAt(j--, str.charAt(i));
            }
        }
        return str.toString();
    }
}

