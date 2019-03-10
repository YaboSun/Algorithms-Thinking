package pdd01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-03-10
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        if (str.length() <= 1)
            System.out.println(str);
        char[] chars1 = str.toCharArray();
        char[] chars2 = str.toCharArray();

        char a = clearBefore(chars1);
        char b = clearAfter(chars2);

        if (a <= b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

    // 第一种 如果后面重复 不添加进去
    private static char clearBefore(char[] chars) {
        ArrayList<Character> characters1 = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == chars[i]) {
                    characters1.remove(i);
                } else {
                    characters1.add(chars[j - 1]);
                }
            }
        }
        return characters1.get(0);
    }

    private static char clearAfter(char[] chars) {
        ArrayList<Character> characters2 = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] != chars[j]) {
                    characters2.add(chars[j - 1]);
                }
            }
        }
        return characters2.get(0);
    }

}
