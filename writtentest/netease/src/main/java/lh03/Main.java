package lh03;

import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-04-07
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] union = new int[n + 1];
        int[] nums = new int[2 * n - 2];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < nums.length - 1; i += 2) {
            union[nums[i + 1]] = nums[i];
        }

        int count = 0;
        for (int i : union) {
            if (i == 0)
                count++;
        }

        System.out.println(count - 1);
    }
}
