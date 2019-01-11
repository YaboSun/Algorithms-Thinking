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
        Integer[] arr = {1, 2, 4, 5, 7, 8, 10, 12, 13};
        int n = 9;
        int target = 10;
        // System.out.println(binarySearch.binarySearchTwo(arr, n, target));
        System.out.println(binarySearch.binarySearchTemplate(arr, target));
    }
}