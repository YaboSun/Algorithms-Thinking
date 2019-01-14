package sort;

import java.util.*;

/**
 * @author YaboSun
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * 给定一个不空的整数数组 返回出现频率最多的k个数
 *
 */
public class LeetCode347 {

    /********************************************************
     *                      个人代码初步实现
     * ******************************************************/
    /**
     * 实现思路：利用一个HashMap存元素以及元素出现次数
     * 将得到的map按照value进行排序
     * 取得topK，输出对应的key存在一个ArrayList并返回
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return null;
        }
        List<Integer> keys = new ArrayList<>();
        Map<Integer, Integer> eleCountMap = new HashMap<>();
        int count = 0;
        // 构造map
        for (int i = 0; i < nums.length; i++) {
            if (!eleCountMap.containsKey(nums[i])) {
                eleCountMap.put(nums[i], 1);
            } else {
                count = eleCountMap.get(nums[i]);
                count++;
                eleCountMap.put(nums[i], count);
            }
        }

        // 取出value
        return keys;
    }

    /********************************************************
     *                      notebook代码
     * 设置若干个桶，每个桶存储出现频率相同的数，并且桶的下标代表桶中数出现的频
     * 率，即第 i 个桶中存储的数出现的频率为 i。
     * 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k
     * 个数。
     * ******************************************************/
    public List<Integer> topKFrequent(int[] nums, int k) {

        // 这里思路相同 构造的过程中别人很简单 学到了
        Map<Integer, Integer> numFrequency = new HashMap<>();
        for (int num : nums) {
            // 这里的处理也很巧妙，直接通过foreach遍历
            // 另外不用判断那么多 直接叠加
            numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
        }

        // 这里还能创建这样的 第一次用都是
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : numFrequency.keySet()) {
            int frequency = numFrequency.get(key); // 这里的frequency对应的是元素出现的频率
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>(); // 对应的frequency创建一个新的ArrayList引用
            }
            buckets[frequency].add(key);
        }

        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] != null) {
                topK.addAll(buckets[i]);
            }
        }

        return topK;
    }
}
