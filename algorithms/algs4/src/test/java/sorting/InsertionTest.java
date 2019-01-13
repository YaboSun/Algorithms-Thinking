package sorting;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class InsertionTest {
    public static void main(String[] args) {
        Insertion insertion = new Insertion();
        Comparable[] arr = new Comparable[]{3,6,7,2};
        insertion.mySort(arr);
    }
}