package tx20190309.second;

import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-03-09
 */
public class Main {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int length = b - a + 1;

            if (a % 2 == 0) {
                if (length % 2 == 0) {
                    System.out.println(-1 * length / 2);
                } else {
                    System.out.println(-1 * (int) (length / 2) + b);
                }
            } else {
                if (length % 2 == 0) {
                    System.out.println(length / 2);
                } else {
                    System.out.println((int) (length / 2) - b);
                }
            }
        }
    }
}
