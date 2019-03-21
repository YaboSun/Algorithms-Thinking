import java.util.ArrayList;
import java.util.List;

/**
 * @author YaboSun
 */
public class LastRemaining45 {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++)
            nums.add(i);

        int index = 0;
        while (nums.size() > 1) {
            index = (index + m - 1) % nums.size();
            nums.remove(index);
        }
        return nums.get(0);
    }
}
