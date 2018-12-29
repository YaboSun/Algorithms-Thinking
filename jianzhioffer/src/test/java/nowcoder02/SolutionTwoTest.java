package nowcoder02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class SolutionTwoTest {

    SolutionTwo solutionTwo = new SolutionTwo();
    @Test
    public void replaceSpace() {
        StringBuffer stringBuffer = new StringBuffer("we are happy");
        System.out.println(solutionTwo.replaceSpace(stringBuffer));
    }
}