package nowcoder11;

/**
 * @author YaboSun
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 思路：
 * 主要分两步：
 * 1 判断是正数还是负数，正数不变，负数求其补码
 * 2 进行递归或非递归除法
 *
 * 思路不行，首先负数是不用处理的，计算机中负数就是用补码表示
 *
 * 直接调用源代码进行求解
 */
public class SolutionOne {
    public int NumberOf1(int n) {
        int count = 0;
        char[] chars = Integer.toBinaryString(n).toCharArray();

        for (char i : chars) {
            if (i == '1') {
                count++;
            }
        }
        return count;
    }

}
