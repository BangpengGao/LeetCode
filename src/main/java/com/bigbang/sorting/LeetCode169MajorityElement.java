package com.bigbang.sorting;

import java.util.HashMap;
import java.util.Map;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/21
 * @ Time 9:55
 */
public class LeetCode169MajorityElement {
    /**
     * Given an array nums of size n, return the majority element.
     * <p>
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     * <p>
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -231 <= nums[i] <= 231 - 1
     * <p>
     * <p>
     * Follow-up: Could you solve the problem in linear time and in O(1) space?
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        //Runtime: 9 ms, faster than 31.43% of Java online submissions for Majority Element.
        //Memory Usage: 43.9 MB, less than 73.26% of Java online submissions for Majority Element.
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int n : nums)
            if (tempMap.containsKey(n))
                tempMap.put(n, tempMap.get(n) + 1);
            else
                tempMap.put(n, 1);
        int solution = 0, count = 0;
        for (int key : tempMap.keySet())
            if (tempMap.get(key) > count) {
                count = tempMap.get(key);
                solution = key;
            }
        return solution;
    }
}
