package com.bigbang.sorting;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/10
 * @since 1.0.0
 */
public class LeetCode747LargestNumberAtLeastTwiceOfOthers {
    /**
     * You are given an integer array nums where the largest integer is unique.
     * <p>
     * Determine whether the largest element in the array is at least twice as much as every other number in the array.
     * If it is, return the index of the largest element, or return -1 otherwise.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,6,1,0]
     * Output: 1
     * Explanation: 6 is the largest integer.
     * For every other number in the array x, 6 is at least twice as big as x.
     * The index of value 6 is 1, so we return 1.
     * Example 2:
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: -1
     * Explanation: 4 is less than twice the value of 3, so we return -1.
     * Example 3:
     * <p>
     * Input: nums = [1]
     * Output: 0
     * Explanation: 1 is trivially at least twice the value as any other number because there are no other numbers.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 50
     * 0 <= nums[i] <= 100
     * The largest element in nums is unique.
     *
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {
        //Runtime: 1 ms, faster than 32.80% of Java online submissions for Largest Number At Least Twice of Others.
        //Memory Usage: 39.1 MB, less than 7.08% of Java online submissions for Largest Number At Least Twice of Others.

        if (nums.length <= 1) return 0;
        int max = nums[0], idx = 0, second = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                idx = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return (second * 2) <= max ? idx : -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        System.out.println(dominantIndex(nums));
    }
}
