package mooc03.quick;

import mooc03.utils.SortTestHelper;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class QuickSortImoocTest {
    public static void main(String[] args) {
        int[] arr = {3,7,1,5,6,4,1};
        int n = 7;
        QuickSortImooc qs = new QuickSortImooc(arr, n);
        assert SortTestHelper.isSorted(arr, n);
    }
}