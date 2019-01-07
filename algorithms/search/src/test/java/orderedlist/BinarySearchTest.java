package orderedlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class BinarySearchTest {

    BinarySearch binarySearch = new BinarySearch();
    @Test
    public void binarySearch() {
        int[] arr = {1, 2, 4, 5, 7, 8, 10, 12, 13};
        int n = 8;
        int target = 10;
        System.out.println(binarySearch.binarySearch(arr, n, target));
    }
}