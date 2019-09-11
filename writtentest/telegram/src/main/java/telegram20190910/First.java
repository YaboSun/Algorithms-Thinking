package telegram20190910;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YaboSun
 */
public class First {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }



        Arrays.sort(nums);

        if (n % 2 != 0) {
            System.out.println(nums[n / 2]);
        } else {
            System.out.println(n / 2 - 1);
        }
    }
}
