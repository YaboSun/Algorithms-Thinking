package nowcoder19;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class SolutionOneTest {

    SolutionOne solutionOne = new SolutionOne();
    @Test
    public void printMatrix() {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        solutionOne.printMatrix(matrix);
    }
}