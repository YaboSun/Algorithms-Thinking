package cyc;

/**
 * @author transwarp
 * @date 19-5-25
 *
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。
 * 给定一个数，判断这个数是否在该二维数组中
 */
public class Find04 {

    /**
     * Consider the following matrix:
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     *
     * 个人解法 初步思路 看了下运行时间140ms 有点高
     * 不过看了下cyc大佬的解法 也是这样的
     * Given target = 5, return true.
     * Given target = 20, return false.
     * 思路：比较每行最后一个数与target大小，如果大i++
     * 反之，j--
     * @param target 给定一个目标数
     * @param matrix 二维数组
     * @return true 如果包含，否则 false
     */
    public boolean find1(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowIdx = 0;
        int colIdx = cols - 1;

        while (rowIdx < rows && colIdx >= 0) {
            if (matrix[rowIdx][colIdx] == target) {
                return true;
            } else if (matrix[rowIdx][colIdx] < target) {
                rowIdx++;
            } else {
                colIdx--;
            }
        }

        return false;
    }
}

