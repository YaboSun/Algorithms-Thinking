package bitopera;


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

}
