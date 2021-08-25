package com.bigbang.sorting;

import java.util.*;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/24
 * @ Time 10:21
 */
public class LeetCode229MajorityElementII {
    /**
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     * <p>
     * Follow-up: Could you solve the problem in linear time and in O(1) space?
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,2,3]
     * Output: [3]
     * Example 2:
     * <p>
     * Input: nums = [1]
     * Output: [1]
     * Example 3:
     * <p>
     * Input: nums = [1,2]
     * Output: [1,2]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 5 * 104
     * -109 <= nums[i] <= 109
     *
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {
        //Runtime: 8 ms, faster than 29.14% of Java online submissions for Majority Element II.
        //Memory Usage: 42.2 MB, less than 76.80% of Java online submissions for Majority Element II.

        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for (int n : nums)
            if (countMap.containsKey(n))
                countMap.put(n, countMap.get(n) + 1);
            else
                countMap.put(n, 1);

        List<Integer> solution = new LinkedList<>();
        int len = nums.length / 3;
        for (Integer key : countMap.keySet())
            if (countMap.get(key) > len)
                solution.add(key);

        return solution;
    }

    /* 改良一版，明显内存占用减少，但是速度却慢下很多 */
    public static List<Integer> majorityElementV2(int[] nums) {
        //Runtime: 14 ms, faster than 6.46% of Java online submissions for Majority Element II.
        //Memory Usage: 41.6 MB, less than 98.50% of Java online submissions for Majority Element II.

        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        Set<Integer> solution = new LinkedHashSet<>();
        int len = nums.length / 3;
        for (int n : nums) {
            // 添加此行代码后，速度加快一点
            //Runtime: 10 ms, faster than 15.21% of Java online submissions for Majority Element II.
            //Memory Usage: 41.8 MB, less than 95.75% of Java online submissions for Majority Element II.
            if (solution.contains(n)) continue;

            if (countMap.containsKey(n))
                countMap.put(n, countMap.get(n) + 1);
            else
                countMap.put(n, 1);

            if (countMap.get(n) > len)
                solution.add(n);
        }

        return new ArrayList<>(solution);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementV2(nums));
    }
}
