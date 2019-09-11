package zh01;

import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-04-09
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int count = 0;
        int maxNum = 0;
        count = n / c;

        if (count < a) {
            maxNum = count;
        } else {
            int k = count / a;
            maxNum = k * b + count;
        }
        System.out.println(maxNum);
    }
}
