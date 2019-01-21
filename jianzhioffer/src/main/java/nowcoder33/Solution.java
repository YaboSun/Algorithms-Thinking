package nowcoder33;

/**
 * @author YaboSun
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
 */
public class Solution {

    /**
     * 思路一：
     *
     * 逐个判断每个整数是不是丑数的解法，直观但不够高效：
     * 所谓一个数m是另一个数n的因子，是指n能被m整除，也就是说n%m==0.根据丑数的定义，丑数只能被2，3，5整除。
     * 也就是说如果一个数能被2整除，我们把它连续除以2；如果能被3整除，就连续除以3；
     * 如果能被5整除，就除以5.如果最后我们得到的是1，那么这个数就是丑数，否则不是。
     * 接下来，我们只需要按照顺序判断每个整数是不是丑数
     *
     * 但是这种方法会超时
     * @param N
     * @return
     */
    public int GetUglyNumber_Solution1(int N) {
        if (N <= 0) {
            return 0;
        }
        int number = 0;
        int uglyFound = 0;
        while (uglyFound < N) {
            number++;
            if (isUgly(number)) {
                ++uglyFound;
            }
        }
        return number;
    }

    public boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }


    /**
     * 最优解 通过空间换取时间
     * 根据丑数的定义，丑数应该是另一个丑数乘以2，3，5的结果
     * 创建一个数组，里面的数字是排序好的丑数，每一个丑数都是前面的丑数乘以2，3，5得到的
     * @param N
     * @return
     */
    public int GetUglyNumber_Solution(int N) {

        if (N <= 6) { // 小于6的都是丑数
            return N;
        }
        int i2 = 0, i3 = 0, i5 = 0; // 分别表示2,3,5
        int[] dp = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            int next2 = dp[i2] * 2;
            int next3 = dp[i3] * 3;
            int next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));

            if (dp[i] == next2) {
                i2++;
            }
            if (dp[i] == next3) {
                i3++;
            }
            if (dp[i] == next5) {
                i5++;
            }
        }
        return dp[N - 1];
    }
}
