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
}
