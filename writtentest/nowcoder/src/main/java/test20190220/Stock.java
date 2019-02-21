package test20190220;

import java.util.Scanner;

/**
 * @author YaboSun
 *
 * 题目描述：
 * 股票种类数N，牛牛有M元
 * N行分别为每支股票买入和卖出的价钱，求最大收益
 *
 * 输入案例：
 * 3 5
 * 3 6
 * 2 3
 * 1 1
 * 输出：
 * 4
 */
public class Stock {
    // 题目可以被抽象为一个多重背包：我们把借来的钱看成容量，
    // 买入价看成物品的重量，卖出价看成物品的价值。答案就等于总价值和总重量的差值。
    // 注意处理所有股票都处于跌价状态的情况。

    // 牛客网上给出的官方答案，运行有问题
    public static int solve1() {
        int[] dp = new int[1005];
        int[][] c = new int[1005][2];

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 1; i <= M; i++)
            dp[i] = i;
        for (int i = 1; i <= N; i++) {
            c[i][0] = sc.nextInt();
            c[i][1] = sc.nextInt();
            for (int j = c[i][0]; j <= M; j++)
                dp[j] = Math.max(dp[j], dp[j - c[i][0] + c[i][1]]);
        }
        System.out.println(dp[M] - M);
        return 0;
    }


}
