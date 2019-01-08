package nowcoder13;

/**
 * @author YaboSun
 */
public class SolutionTwo {
    public void reOrderArray(int [] array) {
        int oddCnt = 0;
        for (int val : array)
            if (val % 2 == 1)
                oddCnt++;
        int[] copy = array.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1)
                array[i++] = num;
            else
                array[j++] = num;
        }
    }
}
