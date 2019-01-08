package doublepointer;

/**
 * @author YaboSun
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 * Input: 3
 * Output: False
 *
 * 题目描述：题目描述： 判断一个数是否为两个数的平方和， 例如 5 = 1^2 + 2^2
 *
 *
 */
public class LeetCode633 {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c); // 这一步数学知识确定遍历范围很关键
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == c) {
                return true;
            } else if (powSum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
