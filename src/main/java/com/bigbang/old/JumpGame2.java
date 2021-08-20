package com.bigbang.old;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/6
 */

public class JumpGame2 {
    /**
     * 45. Jump Game II
     * Hard
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Your goal is to reach the last index in the minimum number of jumps.
     *
     * Example:
     * Input: [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2.
     *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Note:
     * You can assume that you can always reach the last index.
     */
    public int solution1(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public int solution2(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position != 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public static void main(String[] args){
        JumpGame2 j = new JumpGame2();
        int[] a = {2,3,1,1,4};
        System.out.println(j.solution1(a));
    }
}
