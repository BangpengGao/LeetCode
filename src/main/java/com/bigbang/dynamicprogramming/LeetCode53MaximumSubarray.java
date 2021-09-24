package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/24
 * @since 1.0.0
 */
public class LeetCode53MaximumSubarray {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     * A subarray is a contiguous part of an array.
     * <p>
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * <p>
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     * <p>
     * Example 3:
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     * <p>
     * Constraints:
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * <p>
     * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        //Runtime: 2 ms, faster than 19.52% of Java online submissions for Maximum Subarray.
        //Memory Usage: 48.1 MB, less than 6.68% of Java online submissions for Maximum Subarray.
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));
    }
}
