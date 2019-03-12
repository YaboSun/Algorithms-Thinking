package bitopera;

import java.util.Arrays;

/**
 * @author YaboSun
 * 题目描述：数组中唯一一个不重复的元素
 * Input: [4,1,2,1,2]
 * Output: 4
 * 要求不开辟额外空间
 */
public class LeetCode136 {

    public int singleNumber(int[] nums) {
        int ret = 0; // 定义初始值，因为 0 和任何数进行异或结果都为那个数本身
        for (int n : nums)
            ret ^= n;
        return ret;
    }

    /**
     * single number 的变形
     * 现在其他数都出现三次，找出出现一次的数
     * 这种方法其实可以推广到其他数出现 n 次都可以 只需要将 % 的地方修改即可
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        int[] bits = new int[32];
        Arrays.fill(bits, 0);
        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            for (j = 0; j < 32; j++) {
                bits[j] += ((nums[i] >> j) & 1);
            }
        }
        int result = 0;
        for (j = 0; j < 32; j++) {
            if (bits[j] % 3 != 0) {
                result += (1 << j);
            }
        }
        return result;
    }

}
