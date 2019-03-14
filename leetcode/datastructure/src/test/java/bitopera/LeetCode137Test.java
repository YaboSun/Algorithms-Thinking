package bitopera;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class LeetCode137Test {

    @Test
    public void singleNumber() {
        LeetCode137 lc = new LeetCode137();
        int[] nums = {2, 3, 1, 2, 3, 4, 5, 1, 2, 3, 1, 4, 4};
        System.out.println("ones" + " twos");
        System.out.println(lc.singleNumber1(nums));
    }
}