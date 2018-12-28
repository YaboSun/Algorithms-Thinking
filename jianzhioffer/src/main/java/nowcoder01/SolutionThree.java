package nowcoder01;

/**
 * @author YaboSun
 *
 * 试下暴力遍历
 */
public class SolutionThree {
    public boolean Find(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
