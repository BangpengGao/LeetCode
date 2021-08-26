package com.bigbang.sorting;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/25
 * @ Time 17:10
 */
public class LeetCode347TopKFrequentElements {
    /**
     * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     * <p>
     * Input: nums = [1], k = 1
     * Output: [1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 105
     * k is in the range [1, the number of unique elements in the array].
     * It is guaranteed that the answer is unique.
     * <p>
     * <p>
     * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */
    public static int[] topKFrequent(int[] nums, int k) {
        //Runtime: 15 ms, faster than 17.17% of Java online submissions for Top K Frequent Elements.
        //Memory Usage: 41.3 MB, less than 93.47% of Java online submissions for Top K Frequent Elements.

        Map<Integer, Integer> numsMap = new HashMap<>(nums.length);
        for (int n : nums)
            if (numsMap.containsKey(n))
                numsMap.put(n, numsMap.get(n) + 1);
            else
                numsMap.put(n, 1);

        Map<Integer, Integer> result1 = numsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        int[] solution = new int[k];
        for (Map.Entry<Integer, Integer> entry : result1.entrySet()) {
            if (k <= 0) {
                return solution;
            }
            solution[k - 1] = entry.getKey();
            k--;
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};

        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
