/**
 * @author YaboSun
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到 下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断 数组中是否含有该整数
 */
public class FindNum01 {

    /**
     * 初步思路：
     * 1、将target分别与第一行最后一个数进行比较
     * 如果小 那么直接在第一行中进行从后往前遍历查找
     * 如果大 继续在下一行进行查找
     * 直到查找到最后一行 没有返回false
     */
    public boolean Find1(int target, int [][] array) {
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

    // 这种思路和第一种是完全一样的 只不过是没有将长度单独定义为变量
    public boolean Find2(int [][] array, int target) {
        int len = array.length-1;
        int i = 0;
        while((len >= 0) && (i < array[0].length)) {
            if(array[len][i] > target){
                len--;
            } else if(array[len][i] < target) {
                i++;
            } else{
                return true;
            }
        }
        return false;
    }

    // 暴力解法 应该算是最初的思路
    public boolean Find3(int target, int [][] array) {
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
