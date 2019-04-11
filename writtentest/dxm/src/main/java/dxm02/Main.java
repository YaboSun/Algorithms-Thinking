package dxm02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-04-10
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxEarn = 0;
        int min = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        maxEarn = nums[nums.length - 1] - nums[0];
        min = 1;
        System.out.print(maxEarn + " " + min);


    }
}
