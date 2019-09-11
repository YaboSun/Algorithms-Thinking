package mooc03.quick;

import mooc03.utils.SortTestHelper;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class QuickSortImoocTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,6};
        int n = 5;
        QuickSortImooc qs = new QuickSortImooc(arr, n);
        assert SortTestHelper.isSorted(arr, n);
        SortTestHelper.printArr(arr);
    }
}