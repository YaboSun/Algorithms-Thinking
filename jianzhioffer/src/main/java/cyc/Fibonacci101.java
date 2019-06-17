package cyc;

/**
 * @author transwarp
 * @date 19-6-17
 *
 * 要求输入一个整数n，请你输出斐波那契数列的第n项 n<=39
 */
public class Fibonacci101 {

    /**
     * 递归解法
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
}

