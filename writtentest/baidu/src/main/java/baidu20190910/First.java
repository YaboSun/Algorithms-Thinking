package baidu20190910;

import java.util.Scanner;

/**
 * @author YaboSun
 */
public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 员工人数
        int n = scanner.nextInt();
        // 果汁种类数
        int k = scanner.nextInt();

        String line = scanner.nextLine();

        Scanner scanner1 = new Scanner(line);

        // 保存所有种类数
        int[] arr = new int[k + 1];

        for (int i = 0; i < n; i++) {
            int index = scanner.nextInt();
            arr[index] += 1;
        }

        int count = 0;

        for (int i : arr) {
            int num = i / 2;
            if (i % 2 == 0) {
                count += num;
            } else {
                count += (num + 1);
            }
        }

        System.out.println(count);
    }
}
