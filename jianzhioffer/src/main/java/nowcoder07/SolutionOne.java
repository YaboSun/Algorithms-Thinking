package nowcoder07;

/**
 * @author YaboSun
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * f(n) = f(n - 1) + f(n - 2),其中f(0) = 0;f(1) = f(2) = 1
 * 递归调用 最简单实现 但是是最没用的
 */
public class SolutionOne {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
