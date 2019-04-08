/**
 * @author YaboSun
 *
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt48 {
    public int strToInt(String str) {
        if(str == null || str.length() == 0)
            return 0;
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-'))
                continue;
            if (c < '0' || c > '9')
                return 0;
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }
}
