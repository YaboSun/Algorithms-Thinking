package nowcoder44;

import java.util.Arrays;

/**
 * @author YaboSun
 */
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length < 1) {
            return false;
        }

        Arrays.sort(numbers);
        int numOfZero = 0;
        for(int i : numbers) {
            if(i == 0)
                ++numOfZero;
        }
        int numOfGap = 0;
        int i = numOfZero;
        int j = i + 1;
        while(j < numbers.length) {
            if(numbers[i] == numbers[j])
                return false;
            numOfGap += numbers[j] - numbers[i] - 1;
            i = j;
            ++j;
        }
        return numOfZero >= numOfGap;
    }
}
