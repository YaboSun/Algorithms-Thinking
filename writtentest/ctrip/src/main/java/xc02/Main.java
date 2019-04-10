package xc02;

import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-04-08
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();
        String subString = string.substring(1, string.length() - 1);
        String[] strings = subString.split(",");
        int k = sc.nextInt();
        reverseList(strings, k);

        System.out.print("[");
        for (int i = 0; i < strings.length; i++) {
            if (i == strings.length - 1) {
                System.out.print(strings[i]);
            } else {
                System.out.print(strings[i] + ",");
            }
        }

        System.out.print("]");
    }

    private static void reverseList(String[] strings, int k) {
        if (strings == null || strings.length == 0)
            return;
        int n = strings.length / k;
        for (int i = 0; i < n; i++) {
            int l = i * k;
            int h = (i + 1) * k - 1;
            reverse(strings, l, h);
        }

    }

    private static void reverse(String[] strings, int l, int h) {
        while (l <= h) {
            swap(strings, l, h);
            l++;
            h--;
        }
    }

    private static void swap(String[] strings, int i, int j) {
        String tmp = strings[i];
        strings[i] = strings[j];
        strings[j] = tmp;
    }
}
