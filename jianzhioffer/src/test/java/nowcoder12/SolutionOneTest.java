package nowcoder12;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class SolutionOneTest {

    SolutionOne solutionOne = new SolutionOne();
    @Test
    public void power() {
        double d = 3.0;
        int exp = 2;
        System.out.println(solutionOne.Power(d, exp));
    }
}