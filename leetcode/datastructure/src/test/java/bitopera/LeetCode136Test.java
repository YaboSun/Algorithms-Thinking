package bitopera;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class LeetCode136Test {

    @Test
    public void singleNumber() {
        LeetCode136 l = new LeetCode136();

        int[] nums = {2,3,1,2,3,1,4,4,5};

        System.out.println(l.singleNumber(nums));
    }
}