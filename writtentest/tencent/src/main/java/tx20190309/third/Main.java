package tx20190309.third;

import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-03-09
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int s = in.nextInt();
        double ret = fun(n, s) * Math.pow(2, (n - s));
        ret %= 1e9 + 7;
        System.out.println((int) ret);

    }

    private static int fun(int m, int n) {
        double ret = 1;
        for (int i = 0; i < n; i++) {
            ret *= (m - i) * 1.0 / (n - i) ;
        }
        return (int) (ret + 0.5);
    }
}
