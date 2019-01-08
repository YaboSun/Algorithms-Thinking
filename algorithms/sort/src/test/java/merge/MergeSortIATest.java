package merge;

import org.junit.Test;

/**
 * @author YaboSun
 */
public class MergeSortIATest {

    MergeSortIA mergeSortIA = new MergeSortIA();
    @Test
    public void mergeSortIA() {
    }

    @Test
    public void merge() {
        int[] arr = {2, 5, 2, 10, 5, 6, 3, 7};
        int l =  0;
        int r = arr.length - 1;
        int mid = (l + r + 1)/2;
        mergeSortIA.merge(arr, l, mid, r);

    }
}