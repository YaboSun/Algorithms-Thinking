package dxm01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-04-10
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Long> numList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numList.add(sc.nextLong());
        }
        for (int i = 0; i < numList.size(); i++) {
            divCount(numList.get(i));
        }
    }

    private static void divCount(long num) {
        char[] chars = String.valueOf(num).toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0' || num % (chars[i] - '0')  == 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("S");
        } else if (count == chars.length) {
            System.out.println("G");
        } else {
            System.out.println("H");
        }
    }
}
