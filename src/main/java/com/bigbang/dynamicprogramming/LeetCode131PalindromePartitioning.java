package com.bigbang.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/12
 * @since 1.0.0
 */
public class LeetCode131PalindromePartitioning {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return all possible palindrome partitioning of s.
     * A palindrome string is a string that reads the same backward as forward.
     * <p>
     * Example 1:
     * Input: s = "aab"
     * Output: [["a","a","b"],["aa","b"]]
     * <p>
     * Example 2:
     * Input: s = "a"
     * Output: [["a"]]
     * <p>
     * Constraints:
     * 1 <= s.length <= 16
     * s contains only lowercase English letters.
     *
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        //Runtime: 17 ms, faster than 32.49% of Java online submissions for Palindrome Partitioning.
        //Memory Usage: 150.9 MB, less than 28.82% of Java online submissions for Palindrome Partitioning.

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> solution = new ArrayList<>();
        dfs(solution, s, 0, new ArrayList<>(), dp);
        return solution;
    }

    public static void dfs(List<List<String>> solution, String s, int start, List<String> currentList, boolean[][] dp) {
        if (start >= s.length()) solution.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(end) == s.charAt(start) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                currentList.add(s.substring(start, end + 1));
                dfs(solution, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(partition("a"));
    }
}
