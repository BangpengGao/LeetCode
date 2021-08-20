package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/20
 * @ Time 11:13
 */
public class LeetCode164MaximumGap {
    /**
     * Given an integer array nums, return the maximum difference between two successive elements in its sorted form.
     * If the array contains less than two elements, return 0.
     * <p>
     * You must write an algorithm that runs in linear time and uses linear extra space.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,6,9,1]
     * Output: 3
     * Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
     * Example 2:
     * <p>
     * Input: nums = [10]
     * Output: 0
     * Explanation: The array contains less than 2 elements, therefore return 0.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 105
     * 0 <= nums[i] <= 109
     *
     * @param nums
     * @return
     */
    public static int maximumGap(int[] nums) {
        //Runtime: 36 ms, faster than 62.38% of Java online submissions for Maximum Gap.
        //Memory Usage: 53.2 MB, less than 46.35% of Java online submissions for Maximum Gap.

        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i] - nums[i - 1]) max = nums[i] - nums[i - 1];
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(maximumGap(nums));

        int[] nums2 = {1, 10000000};
        System.out.println(maximumGap(nums2));
    }
}
