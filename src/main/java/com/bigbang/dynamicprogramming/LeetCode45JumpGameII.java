package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/24
 * @since 1.0.0
 */
public class LeetCode45JumpGameII {
    /**
     * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Your goal is to reach the last index in the minimum number of jumps.
     * You can assume that you can always reach the last index.
     * <p>
     * Example 1:
     * Input: nums = [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2.
     * Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * <p>
     * Example 2:
     * Input: nums = [2,3,0,1,4]
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        //贪心
        //Runtime: 1 ms, faster than 99.52% of Java online submissions for Jump Game II.
        //Memory Usage: 39.5 MB, less than 81.16% of Java online submissions for Jump Game II.
        
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0};
        System.out.println(jump(nums));
    }
}
