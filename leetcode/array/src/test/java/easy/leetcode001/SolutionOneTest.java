package easy.leetcode001;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class SolutionOneTest {
    SolutionOne solutionOne = new SolutionOne();
    @Test
    public void twoSum() {
        int[] nums = {2, 5, 11, 15};
        int target = 9;
        int[] ints = solutionOne.twoSum(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}