package test20190314;

import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-03-14
 */
public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n <= 2 * (k - 2))
            System.out.println();
        else
            print(n, k);
    }

    private static void print(int n, int k) {
        for (int i = 0; i < k; i++) {
            if (n - 2 * i - 1 > 0) {

            }
        }
    }
}
