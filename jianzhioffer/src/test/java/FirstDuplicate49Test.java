import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class FirstDuplicate49Test {
    public static void main(String[] args) {
        FirstDuplicate49 f = new FirstDuplicate49();
        int[] nums = {2, 1, 3, 1, 4};
        int length = 5;
        int[] dumplication = {1};
        assertTrue(f.duplicate(nums, length, dumplication));
    }
}