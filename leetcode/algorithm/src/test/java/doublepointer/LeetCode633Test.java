package doublepointer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class LeetCode633Test {

    LeetCode633 leetCode633 = new LeetCode633();
    @Test
    public void judgeSquareSum() {
        int n = 5;
        boolean b = leetCode633.judgeSquareSum(n);
        assertTrue(b);
    }
}