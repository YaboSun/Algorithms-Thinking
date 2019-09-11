package telegram20190910;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author YaboSun
 */
public class Second {

    public static void main(String[] args) {
        Map<Integer, Character> map = new HashMap<>();

        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');

        int[] nums = {1,5,10,50,100,500,1000};

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        int i = nums.length - 1;
        while (i >= 0) {
            if (num == nums[i]) {
                System.out.println(stringBuilder.append(map.get(nums[i])));
                return;
            } else if (num > nums[i]) {
                stringBuilder.append(map.get(nums[i]));
                num -= nums[i];
            } else {
                i--;
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
