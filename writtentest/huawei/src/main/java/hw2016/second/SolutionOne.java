package hw2016.second;

import java.util.*;

/**
 * @author YBSun
 * Created in 2019-01-02
 * 第一次解决答案
 *
 * 输入一个字符串，求出该字符串包含的字符集合
 *
 * 输入描述:
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 *
 * 输出描述:
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 *
 * 输入例子1:
 * abcqweracb
 *
 * 输出例子1:
 * abcqwer
 */
public class SolutionOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strings = str.split("");
            List<String> stringList = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();

            for (String string : strings) {
                if (!stringList.contains(string)) {
                    stringList.add(string);
                }
            }
            for (int i = 0; i < stringList.size(); i++) {

                String s = stringList.get(i);
                stringBuilder = stringBuilder.append(s);
            }
            System.out.println(stringBuilder);
        }
    }
}
