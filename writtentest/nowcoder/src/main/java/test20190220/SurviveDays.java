package test20190220;

import java.util.Scanner;

/**
 * @author YBSun
 * Created in 2019-02-20
 *
 * 题目描述
 * 牛牛离家出走最多可以生存多少天
 * 每天必须吃一个苹果，付x元房租
 * 现在手里有f个水果，水果吃完可以买，一个p元
 *
 * 示例输入：
 * 3 5 100 10
 * 输出：
 * 11
 */
public class SurviveDays {

    public static int solve() {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(); // 每天房租
        int f = sc.nextInt(); // 已有水果
        int d = sc.nextInt(); // 已有钱
        int p = sc.nextInt(); // 水果价钱

        int tmp1 = d / x; // 已有钱可以付房租天数
        if (tmp1 <= f)
            return tmp1;
        d -= f * x;
        return f + d / (x + p);
    }
}
