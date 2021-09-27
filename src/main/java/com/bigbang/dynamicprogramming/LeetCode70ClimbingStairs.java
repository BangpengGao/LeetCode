package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/27
 * @since 1.0.0
 */
public class LeetCode70ClimbingStairs {
    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * <p>
     * Example 2:
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     * <p>
     * Constraints:
     * 1 <= n <= 45
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        //斐波那契数列
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
        //Memory Usage: 35.7 MB, less than 76.67% of Java online submissions for Climbing Stairs.
        int solution1 = 1, solution2 = 2;
        if (n == 1) return solution1;
        if (n == 2) return solution2;
        int idx = 3, solution = 0;
        while (idx <= n) {
            solution = solution2;
            solution2 += solution1;
            solution1 = solution;
            idx++;
        }

        return solution2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
