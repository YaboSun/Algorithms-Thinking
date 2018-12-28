package nowcoder01;

/**
 * @author YaboSun
 *
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class SolutionOne {
    public boolean Find(int target, int [][] array) {
        /**
         * 初步思路：
         * 1、将target分别与第一行最后一个数进行比较
         * 如果小 那么直接在第一行中进行从后往前遍历查找
         * 如果大 继续在下一行进行查找
         * 直到查找到最后一行 没有返回false
         */
        int rows = array.length; // 表示数组行数
        int cols = array[0].length; // 表示数组列数
        int r = 0; // 行遍历下标
        int c = cols - 1; // 每一行中列遍历下标
        while (r < rows && c >= 0) {
            if (target > array[r][c]) {
                r++;
            } else if (target < array[r][c]) {
                c--;
            } else {
                return true;
            }
        }
        return false;
    }
}
