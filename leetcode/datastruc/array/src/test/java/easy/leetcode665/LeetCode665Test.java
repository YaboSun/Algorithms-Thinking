package easy.leetcode665;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class LeetCode665Test {

    SolutionOne solutionOne = new SolutionOne();
    SolutionTwo solutionTwo = new SolutionTwo();

    @Test
    public void checkPossibility() {
        int[] nums = {3, 4, 2, 3};
        // System.out.println(solutionOne.checkPossibility(nums));
        System.out.println(solutionTwo.checkPossibility(nums));
    }
}