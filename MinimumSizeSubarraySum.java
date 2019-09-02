package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/27
 */


public class MinimumSizeSubarraySum {
    /**
     * 209. Minimum Size Subarray Sum
     * Medium
     *
     * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
     *
     * Example:
     *
     * Input: s = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
     * Follow up:
     * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
     */

    /**
     * 解题思路：
     * 两点滑动，首先找出从开始到当前位置的值的和大于s，然后收缩范围
     */
    public int solution1(int s, int[] nums) {
        int res = Integer.MAX_VALUE, nsum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            nsum += nums[i];
            while (nsum >= s) {
                res = Math.min(res, i - left + 1);
                nsum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
