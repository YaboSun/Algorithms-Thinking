package nowcoder35;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YBSun
 * Created in 2019-02-11
 */
public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void test() {
        int[] array = {1,2,3,4,5,6,7,0};
        solution.InversePairs1(array);
    }
}