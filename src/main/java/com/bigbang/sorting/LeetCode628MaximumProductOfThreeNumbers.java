package com.bigbang.sorting;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/7
 * @since 1.0.0
 */
public class LeetCode628MaximumProductOfThreeNumbers {
    /**
     * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3]
     * Output: 6
     * Example 2:
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: 24
     * Example 3:
     * <p>
     * Input: nums = [-1,-2,-3]
     * Output: -6
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 3 <= nums.length <= 104
     * -1000 <= nums[i] <= 1000
     *
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        //Runtime: 9 ms, faster than 61.82% of Java online submissions for Maximum Product of Three Numbers.
        //Memory Usage: 40.1 MB, less than 89.63% of Java online submissions for Maximum Product of Three Numbers.

        Arrays.sort(nums);
        if (nums[0] < 0 && nums[1] < 0) {
            return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
        }
        return nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3};
        System.out.println(maximumProduct(nums));
    }
}
