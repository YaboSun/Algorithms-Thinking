package test20190314;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-03-14
 */
public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] - b[i] == 0) {
                tmp += 0;
            } else if (a[i] - b[i] > 0){
                tmp = a[i] + b[i];
            } else {
                for (int j = n - 1; j > i; j--) {

                }
            }
        }
        System.out.println(tmp);
    }
}
