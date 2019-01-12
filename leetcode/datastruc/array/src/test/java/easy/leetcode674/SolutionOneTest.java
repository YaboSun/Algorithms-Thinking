package easy.leetcode674;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class SolutionOneTest {

    SolutionOne solutionOne = new SolutionOne();
    @Test
    public void findLengthOfLCIS() {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(solutionOne.findLengthOfLCIS(nums));
    }
}