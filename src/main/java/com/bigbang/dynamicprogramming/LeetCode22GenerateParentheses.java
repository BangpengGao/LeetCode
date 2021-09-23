package com.bigbang.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/23
 * @since 1.0.0
 */
public class LeetCode22GenerateParentheses {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * <p>
     * Example 2:
     * Input: n = 1
     * Output: ["()"]
     * <p>
     * Constraints:
     * 1 <= n <= 8
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        //回溯
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Generate Parentheses.
        //Memory Usage: 38.9 MB, less than 86.51% of Java online submissions for Generate Parentheses.

        List<String> solution = new ArrayList<>();
        backtrack(solution, new StringBuilder(), 0, 0, n);
        return solution;
    }

    public static void backtrack(List<String> solution, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == 2 * max) {
            solution.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append("(");
            backtrack(solution, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrack(solution, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }
}
