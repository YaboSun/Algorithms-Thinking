package nowcoder23;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class SolutionOneTest {
    public static void main(String[] args) {
        SolutionOne solutionOne = new SolutionOne();
        int[] sequence = {7, 9, 8, 6, 12, 11, 10};
        assertTrue(solutionOne.VerifySquenceOfBST(sequence));
    }

}