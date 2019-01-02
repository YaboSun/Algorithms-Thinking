package easy.leetcode697;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YaboSun
 *
 * 给定一个数组 求出现次数最多的元素
 * 包含出现次数最多的连续数组的最短长度
 *
 * 比如[1,2,2,3,1],出现次数最多的元素分别为1和2
 * 但是包含1或2的子数组有6种，其中长度最短的子数组为[2,2]故长度为2
 *
 *
 * 初步思想：
 * 暴力解法，使用HashMap记录每个数字出现的次数<key,value>对应
 * 字母以及字母出现的次数
 *
 * TODO 解决方案有问题　参考Discuss，见SolutionTwo
 */
public class SolutionOne {
    public int findShortestSubArray(int[] nums) {
        int key = 0;
        int value = 1;
        int maxValue = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            key = i;
            for (int j = 0; j < nums.length; j++) {
                if (key == nums[j]) {
                    value++;
                    map.put(key, value);
                } else {
                    map.put(key, value);
                    key = j;
                    map.put(key, value);
                }
            }
        }
        for (int i = 0; i < map.size(); i++) {
            int numValue = map.get(i);
            maxValue = Math.max(numValue, maxValue);
        }
        return maxValue;
    }
}
