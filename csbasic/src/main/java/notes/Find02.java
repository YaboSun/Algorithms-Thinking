package notes;

/**
 * @author YaboSun
 */
public class Find02 {
    // 设想通过二分搜索来实现每次，但是有个问题就是如果第一个行没有找到

    public boolean find1(int target, int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            int col = cols - 1;
            if (matrix[row][col] < target) {
                col--;
            } else if (matrix[row][col] > target) {
                if (binarySearch(target, matrix[row], 0, col)) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int target, int[] arr, int l, int h) {
        int mid = l + (h - l) / 2;

        while (l < h) {
            if (arr[mid] == target)
                return true;
            else if (arr[mid] > target) {
                binarySearch(target, arr, l, mid);
            } else {
                binarySearch(target, arr, mid + 1, h);
            }
        }
        return false;
    }

    // 笔记中解法实现
    public boolean find02(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;

        while (row < rows - 1 && col >= 0) {
            if (target == matrix[row][col])
                return true;
            else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }
}
