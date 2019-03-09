package tx20190309.first;

import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-03-09
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = 0;

        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();

            count = m % n;
            int res = m / n;

            if (count != 0) {
                res += 1;
            }
            System.out.println(res);
        }

    }
}
