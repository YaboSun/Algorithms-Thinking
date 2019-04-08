package notes;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class Find02Test {

    public static void main(String[] args) {
        Find02 find02 = new Find02();
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 12;
        assertTrue(find02.find02(target, matrix));
    }
}