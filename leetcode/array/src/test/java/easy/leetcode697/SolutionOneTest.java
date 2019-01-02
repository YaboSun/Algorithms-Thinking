package easy.leetcode697;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class SolutionOneTest {

    SolutionTwo solutionTwo = new SolutionTwo();
    @Test
    public void findShortestSubArray() {
        int[] nums = {1, 3, 5, 4, 7};
        solutionTwo.findShortestSubArray(nums);
    }
}