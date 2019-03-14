package test20190314;

import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-03-14
 */
public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[] chars1 = sc.next().toCharArray();
        char[] chars2 = sc.next().toCharArray();

        int count = 0;
        for (int i = 0; i < n; i++) {
            int a = new Integer(chars1[i]);
            int b = new Integer(chars2[i]);
            int tmp = Math.abs(a - b);
            if (tmp >= 5) {
                count += (10 - tmp);
            } else {
                count += tmp;
            }
        }
        System.out.println(count);
    }
}
