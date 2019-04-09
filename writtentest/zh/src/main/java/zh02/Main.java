package zh02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-04-09
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] nums = new int[n * 2];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        double max = 0;
        if (nums[0] * 2 <= nums[nums.length / 2]) {
            max = 3 * n * nums[0];
        } else {
            max = 1.5 * n * nums[nums.length / 2];
        }
        if (max > w) {
            max = w;
        }
        System.out.printf("%.6f", max);
    }
}
