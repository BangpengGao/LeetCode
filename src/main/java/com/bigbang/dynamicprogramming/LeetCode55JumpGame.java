package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/24
 * @since 1.0.0
 */
public class LeetCode55JumpGame {
    /**
     * You are given an integer array nums. You are initially positioned at the array's first index,
     * and each element in the array represents your maximum jump length at that position.
     * Return true if you can reach the last index, or false otherwise.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * <p>
     * Example 2:
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
     * which makes it impossible to reach the last index.
     * <p>
     * Constraints:
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 105
     *
     * @param nums
     * @return
     */
    public static boolean jump(int[] nums) {
        //贪心
        //Runtime: 3 ms, faster than 51.08% of Java online submissions for Jump Game.
        //Memory Usage: 64.2 MB, less than 16.29% of Java online submissions for Jump Game.

        int curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                curEnd = curFarthest;
            }
        }
        return curEnd >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0};
        System.out.println(jump(nums));
    }
}
