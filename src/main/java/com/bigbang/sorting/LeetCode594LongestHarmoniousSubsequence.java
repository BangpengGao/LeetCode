package com.bigbang.sorting;

import java.util.*;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/9/6
 * @ Time 9:38
 */
public class LeetCode594LongestHarmoniousSubsequence {
    /**
     * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
     * <p>
     * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
     * <p>
     * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,3,2,2,5,2,3,7]
     * Output: 5
     * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
     * Example 2:
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: 2
     * Example 3:
     * <p>
     * Input: nums = [1,1,1,1]
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 2 * 104
     * -109 <= nums[i] <= 109
     *
     * @param nums
     * @return
     */
    public static int findLHS(int[] nums) {
        //Runtime: 46 ms, faster than 14.54% of Java online submissions for Longest Harmonious Subsequence.
        //Memory Usage: 41.9 MB, less than 22.23% of Java online submissions for Longest Harmonious Subsequence.

        Map<Integer, Integer> integerMap = new HashMap<>();
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        for (int n : nums) {
            integerMap.put(n, integerMap.getOrDefault(n, 0) + 1);
            set.add(n);
        }
        Integer solution = 0, temp = null;
        for (Integer s : set) {
            if (temp == null) {
                temp = s;
                continue;
            }
            if (Math.abs(s - temp) == 1 && integerMap.get(s) + integerMap.get(temp) > solution)
                solution = integerMap.get(s) + integerMap.get(temp);
            temp = s;
        }

        return solution;
    }

    public static int findLHSV2(int[] nums) {
        //Runtime: 46 ms, faster than 14.54% of Java online submissions for Longest Harmonious Subsequence.
        //Memory Usage: 41.9 MB, less than 22.23% of Java online submissions for Longest Harmonious Subsequence.

        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int n : nums) {
            integerMap.put(n, integerMap.getOrDefault(n, 0) + 1);
        }
        int solution = 0;
        for (Integer key : integerMap.keySet()) {
            if (integerMap.containsKey(key + 1))
                solution = Math.max(solution, integerMap.get(key) + integerMap.get(key + 1));
        }

        return solution;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(findLHS(nums));

        int[] nums1 = {-3, -1, -1, -1, -3, -2};
        System.out.println(findLHS(nums1));

        int[] nums2 = {1, 3, 1, 3, 2, 3, 0, 3, 0, 1, 2, 2, 2, -1, 2, 1, 0, 0, 2, 2, 3, -3, 1, 2, 2, 0, 1, 3, 1};
        System.out.println(findLHS(nums2));
    }
}
