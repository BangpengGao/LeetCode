package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/28
 * @since 1.0.0
 */
public class LeetCode213HouseRobberII {
    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed.
     * All houses at this place are arranged in a circle.
     * That means the first house is the neighbor of the last one.
     * Meanwhile, adjacent houses have a security system connected,
     * and it will automatically contact the police if two adjacent houses were broken into on the same night.
     * Given an integer array nums representing the amount of money of each house,
     * return the maximum amount of money you can rob tonight without alerting the police.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: nums = [2,3,2]
     * Output: 3
     * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
     * <p>
     * Example 2:
     * Input: nums = [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     * <p>
     * Example 3:
     * Input: nums = [1,2,3]
     * Output: 3
     * <p>
     * Constraints:
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 1000
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
        //Memory Usage: 36.3 MB, less than 74.82% of Java online submissions for House Robber II.

        int len = nums.length;
        if (len==1) return nums[0];
        return Math.max(rob(nums, 0, len - 1), rob(nums, 1, len));
    }

    public static int rob(int[] nums, int start, int end) {
        int yes = 0, no = 0;
        for (int i = start; i < end; i++) {
            int temp = no;
            no = Math.max(yes, no);
            yes = nums[i] + temp;
        }
        return Math.max(no, yes);
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(rob(nums));
    }
}
