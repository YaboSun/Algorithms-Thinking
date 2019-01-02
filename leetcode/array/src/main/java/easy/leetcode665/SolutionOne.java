package easy.leetcode665;

/**
 * @author YaboSun
 *
 * 给定一个数组，如果满足当且仅当修改其中一个元素可以
 * 使原数组变为非递减序列则返回true 否则返回false
 */
public class SolutionOne {
    public boolean checkPossibility(int[] nums) {
        /**
         * 初步想法:
         * 从开始判断 如果出现一次以上递减则返回false 存在问题3,4,2,3
         *
         * 进一步解决：
         * 应该考虑三个数的大小关系
         * 对于nums[i]、nums[i - 1]、nums[i - 2]
         */
        int flag = 0; // 记录递减的次数
        int idx = 0; // 记录递减的位置
        if (nums.length > 2) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    flag++;
                    if (i >= 2) {
                        idx = i - 2;
                    }
                }
            }
            int numBefore = nums[idx + 2] - nums[idx];
            int numAfter = nums[idx + 1] - nums[idx + 2];
            if (flag != 1 && numBefore > 0 && numBefore < numAfter) {
                return false;
            }
        }
        return true;
    }
}
