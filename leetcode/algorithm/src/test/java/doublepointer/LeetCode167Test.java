package doublepointer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class LeetCode167Test {
    LeetCode167 leetCode167 = new LeetCode167();
    @Test
    public void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        leetCode167.twoSum(nums, 9);
    }
}