package sorting;

import sorting.utils.SortHelper;


import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class SelectionTest {
    public static void main(String[] args) {
        Comparable[] arr = new Comparable[]{3,6,7,2};
        Selection.mySelectionSort(arr);
        assert SortHelper.isSorted(arr);
    }
}