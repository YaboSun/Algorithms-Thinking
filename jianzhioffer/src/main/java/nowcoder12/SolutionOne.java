package nowcoder12;

/**
 * @author YaboSun
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方、
 *
 *  * 1.全面考察指数的正负、底数是否为零等情况。
 *  * 2.写出指数的二进制表达，例如13表达为二进制1101。
 *  * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
 *  * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
 */
public class SolutionOne {
    /**
     * 求double类型数的n次方
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double res = 1, curr = base;
        int finalExponent;

        if(exponent > 0){
            finalExponent = exponent;
        } else if(exponent < 0) {
            if(base == 0)
                throw new RuntimeException("分母不能为0");
            finalExponent = -exponent;
        } else { // n==0
            return 1;// 0的0次方
        }

        while(finalExponent != 0){
            // 将求余操作利用&实现 提高性能
            if((finalExponent & 1) == 1)
                res *= curr;
            curr *= curr;// 翻倍
            finalExponent >>= 1; // 右移一位
        }
        return exponent >= 0 ? res : (1/res);
    }
}
