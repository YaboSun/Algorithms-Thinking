import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YBSun
 * Created in 2019-05-05
 */
public class MaxInWindows64Test {

    @Test
    public void maxInWindows() {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size= 3;
        MaxInWindows64 max = new MaxInWindows64();
        max.maxInWindows(num, size);
    }
}