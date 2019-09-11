package baidu20190910;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YaboSun
 */
public class Three {

    public static void main(String[] args) {
        int[] needNum = {0,2,5,5,4,5,6,3,7,6};

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 可以选择的数字需要的火柴
        int[] nums = new int[m - 1];
        for (int i = 0; i < m; i++) {
            nums[i] = needNum[scanner.nextInt()];
        }

        Arrays.sort(nums);

        // 记录可以拼的数字
        int[] num = new int[m];
        // 记录可以拼的数字对应的个数
        int count = 0;
        // 从最小的开始遍历
        for (int i : nums) {
            if (n % i == 0) {
                count = n / i;

            } else {
                count = n / i;
                n = count % i;
            }
        }

        System.out.println(count);
    }
}
