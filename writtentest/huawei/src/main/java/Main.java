import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-02-20
 */
public class Main {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        long x = sc.nextInt(); // 每天房租
        long f = sc.nextInt(); // 已有水果
        long d = sc.nextInt(); // 已有钱
        long p = sc.nextInt(); // 水果价钱

        // 初始水果够 已有钱不够房钱
        if (x * f > d) {
            for (long i = f; i >= 0; i--) {
                if (x * i <= d) {
                    System.out.println(i);
                }
            }
        } else if (x * f < d) {
            long i = (d - x * f) / (x + p);
            System.out.println(i + f);
        } else {
            System.out.println(f);
        }
    }*/
        int max = 0; // 记录当前可以获得的最大钱数
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 股票种数
        int M = sc.nextInt(); // 借钱数

        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            X.add(sc.nextInt());
            Y.add(sc.nextInt());
            value.add(Y.get(i) - X.get(i));
        }

        for (int i = 0; i < N; i++) {
            if (X.get(i) == M) {
                max = Math.max(max, value.get(i));
            } else if (X.get(i) < M) {
                for (int j = i + 1; j < N; j++) {
                    if (X.get(i) + X.get(j) == M) {
                        max = Math.max(max, value.get(i) + value.get(j));
                    }
                }
            }
        }
        System.out.println(max);
    }
}
