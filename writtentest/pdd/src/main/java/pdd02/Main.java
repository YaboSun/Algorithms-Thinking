package pdd02;

import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-03-10
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] loc = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            loc[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        int maxValue = maxMoney(loc, value, d);
        System.out.println(maxValue);
    }

    private static int maxMoney(int[] loc, int[] value, int d) {
        int maxValue = 0;
        /*for (int i = 0; i < loc.length; i++) {
            int nextLoc = loc[i] + d;
            int j = (loc.length - i) / 2;
            while (loc[j] >= nextLoc) {
                j--;
            }
            for (j = j + 1; j < loc.length; j++) {
                int tmp = value[j] + value[i];
                maxValue = Math.max(maxValue,tmp);
            }
        }
        return maxValue;*/
        for (int i = 0; i < loc.length; i++) {
            for (int j = i + 1; j < loc.length; j++) {
                if (loc[j] - loc[i] >= d) {
                    int tmp = value[i] + value[j];
                    maxValue = Math.max(maxValue, tmp);
                }
            }
        }
        return maxValue;
    }
}
