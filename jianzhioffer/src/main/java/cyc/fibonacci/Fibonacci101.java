package cyc.fibonacci;

/**
 * @author transwarp
 * @date 19-6-17
 *
 * 要求输入一个整数n，请你输出斐波那契数列的第n项 n<=39
 */
public class Fibonacci101 {

    /**
     * 递归解法
     * 通过开辟一个n+1大小的数组，对应第n项值
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

    /**
     * 优化上一解法的空间复杂度
     * 因为计算第n项，只需要知道前两项即可
     * @param n
     * @return
     */
    public int Fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }
        int pre1 = 1;
        int pre2 = 0;
        int fib = 0;

        for (int i = 2; i <= n; i++) {
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }

        return fib;
    }
}

