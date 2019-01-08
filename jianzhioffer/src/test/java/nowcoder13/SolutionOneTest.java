package nowcoder13;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class SolutionOneTest {

    SolutionOne solutionOne = new SolutionOne();
    @Test
    public void reOrderArray() {
        int[] arr = {1,2,3,4,5,6,7};
        solutionOne.reOrderArray(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}