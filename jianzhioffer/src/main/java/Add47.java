/**
 * @author YaboSun
 *
 * 写一个函数， 求两个整数之和， 要求不得使用 +、 -、 *、 / 四则运算符号
 */
public class Add47 {
    // 思路
    // a ^ b 表示没有考虑进位的情况下两数的和， (a & b) << 1 就是进位
    public int Add(int num1,int num2) {
        return num2 == 0 ? num1 : Add((num1 ^ num2), (num1 & num2) << 1);
    }
}
