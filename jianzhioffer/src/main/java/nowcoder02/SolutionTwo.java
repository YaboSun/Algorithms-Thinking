package nowcoder02;

/**
 * @author YaboSun
 *
 * 别人的解法 时间要短
 */
public class SolutionTwo {
    public String replaceSpace(StringBuffer str) {
        int P1 = str.length() - 1; // 指向原有字符串末尾
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }

    public String replaceSpace2(StringBuffer str) {
        if(str == null || str.length() == 0) {
            return null;
        }
        // 定义指向str当前末尾的指针p
        int p = str.length() - 1;
        // 遍历字符串得到包含的空格数
        for(int i = 0; i <= p; i++) {
            if(str.charAt(i) == ' ') { // 如果找到空格，就在str末尾追加2个空格
                str.append("  "); // 因为原来有一个空格%20占三个空格
            }
        }
        int q = str.length() - 1; // 定义指向已经追加的字符串末尾的指针
        while (p >= 0 && p < q) {
            char c = str.charAt(p--);
            if (c == ' ') { // 倒序遍历，如果找到空格，将q所在的位置一依次变为02%
                str.setCharAt(q--, '0');
                str.setCharAt(q--, '2');
                str.setCharAt(q--, '%');
            } else {
                str.setCharAt(q--, c);
            }
        }
        return str.toString();
    }
}
