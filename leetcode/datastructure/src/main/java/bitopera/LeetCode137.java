package bitopera;

/**
 * @author YaboSun
 */
public class LeetCode137 {
    /**
     * single number 的变形
     * 现在其他数都出现三次，找出出现一次的数
     * 要求运行时间为线性，不使用额外空间
     * 这种方法其实可以推广到其他数出现 n 次都可以 只需要将 % 的地方修改即可
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        int i, j;
        for (i = 0; i < nums.length; i++) {
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

    // 这种解法理解不了，～操作是怎么进行的？
    // 参考https://cloud.tencent.com/developer/article/1131945
    public int singleNumber1(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
            System.out.println(ones + " " + twos);
        }
        return ones;
    }
}
