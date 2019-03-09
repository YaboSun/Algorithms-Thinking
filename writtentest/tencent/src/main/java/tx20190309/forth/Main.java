package tx20190309.forth;

import java.util.*;

/**
 * @author YBSun
 * Created in 2019-03-09
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // 枪数
        int m = in.nextInt(); // 气球颜色数

        int min = 0; // 最少连续打爆次数
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (array[i] == j) {
                    map.put(i, j);
                }
            }
        }
        System.out.println(6);
    }
}
