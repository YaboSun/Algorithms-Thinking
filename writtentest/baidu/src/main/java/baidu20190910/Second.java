package baidu20190910;

import java.util.Scanner;

/**
 * @author YaboSun
 */
public class Second {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] money = new int[n];
        int[] moneyNums = new int[n];

        for (int i = 0; i < n; i++) {
            money[i] = scanner.nextInt();
            moneyNums[i] = scanner.nextInt();
        }
        // 记录当前钱最大值
        int curMoney = 0;
        // 记录当前能支付工资的月数
        int count = 0;
        for (int i = 0; i < money.length; i++) {
            if (money[i] >= m && curMoney == 0) {
                count += money[i] / m * moneyNums[i];
            } else if (money[i] < m){
                curMoney += money[i];
                if (curMoney >= m) {
                    count += moneyNums[i];
                }
            }
        }

        System.out.println(count);
    }
}
