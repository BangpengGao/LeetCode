package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/28
 * @since 1.0.0
 */
public class LeetCode198HouseRobber {
    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that
     * adjacent houses have security systems connected and it will automatically contact the police
     * if two adjacent houses were broken into on the same night.
     * Given an integer array nums representing the amount of money of each house,
     * return the maximum amount of money you can rob tonight without alerting the police.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: nums = [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     * <p>
     * Example 2:
     * Input: nums = [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     * Total amount you can rob = 2 + 9 + 1 = 12.
     * <p>
     * Constraints:
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
        //Memory Usage: 36.6 MB, less than 51.02% of Java online submissions for House Robber.
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }

    public static int robV2(int[] nums) {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
        //Memory Usage: 36.7 MB, less than 51.02% of Java online submissions for House Robber.

        int yes = 0, no = 0;
        for (int n : nums) {
            int temp = no;
            no = Math.max(yes, no);
            yes = temp + n;
        }
        return Math.max(no, yes);
    }

    public static void main(String[] args) {

    }
}
