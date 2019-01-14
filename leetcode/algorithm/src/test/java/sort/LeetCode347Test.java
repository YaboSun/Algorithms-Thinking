package sort;

import static org.junit.Assert.*;

/**
 * @author YBSun
 * Created in 2019-01-14
 */
public class LeetCode347Test {
    public static void main(String[] args) {
        LeetCode347 leetCode347 = new LeetCode347();
        int[] nums = {1,2,2,3};
        int k = 2;
        leetCode347.topKFrequent(nums, k);
    }
}