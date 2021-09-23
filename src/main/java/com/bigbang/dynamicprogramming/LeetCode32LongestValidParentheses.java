package com.bigbang.dynamicprogramming;

import java.util.Stack;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/23
 * @since 1.0.0
 */
public class LeetCode32LongestValidParentheses {
    /**
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) parentheses substring.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: s = "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()".
     * <p>
     * Example 2:
     * Input: s = ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()".
     * <p>
     * Example 3:
     * Input: s = ""
     * Output: 0
     * <p>
     * Constraints:
     * 0 <= s.length <= 3 * 104
     * s[i] is '(', or ')'.
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        //堆栈暂存的方式
        //Runtime: 2 ms, faster than 76.71% of Java online submissions for Longest Valid Parentheses.
        //Memory Usage: 39.2 MB, less than 52.68% of Java online submissions for Longest Valid Parentheses.

        int solution = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    solution = Math.max(solution, i - stack.peek());
                }
            }
        }

        return solution;
    }

    /**
     * 采用动态规划的方式解决
     *
     * @param s
     * @return
     */
    public static int longestValidParenthesesV2(String s) {
        //Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Valid Parentheses.
        //Memory Usage: 39.2 MB, less than 52.68% of Java online submissions for Longest Valid Parentheses.

        int solution = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                solution = Math.max(solution, dp[i]);
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
        System.out.println(longestValidParenthesesV2("()(()"));
    }
}
