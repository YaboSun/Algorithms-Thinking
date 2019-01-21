package nowcoder33;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class SolutionTest {

    public static void main(String[] args) {
        int N = 10000;
        Solution solution = new Solution();
        System.out.println(solution.GetUglyNumber_Solution(N));

        System.out.println(solution.GetUglyNumber_Solution1(N));
    }

}