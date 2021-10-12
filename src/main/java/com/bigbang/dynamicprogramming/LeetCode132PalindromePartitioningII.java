package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/12
 * @since 1.0.0
 */
public class LeetCode132PalindromePartitioningII {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return the minimum cuts needed for a palindrome partitioning of s.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: s = "aab"
     * Output: 1
     * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
     * <p>
     * Example 2:
     * Input: s = "a"
     * Output: 0
     * <p>
     * Example 3:
     * Input: s = "ab"
     * Output: 1
     * <p>
     * Constraints:
     * 1 <= s.length <= 2000
     * s consists of lower-case English letters only.
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        //Runtime: 37 ms, faster than 51.03% of Java online submissions for Palindrome Partitioning II.
        //Memory Usage: 44.7 MB, less than 42.65% of Java online submissions for Palindrome Partitioning II.

        int len = s.length();
        int[] solution = new int[len];
        boolean[][] dp = new boolean[len + 1][len + 1];
        for (int start = 0; start < len; ++start) {
            solution[start] = start;
            for (int end = 0; end <= start; ++end) {
                if (s.charAt(end) == s.charAt(start) && (start - 1 < end + 1 || dp[end + 1][start - 1])) {
                    dp[end][start] = true;
                    solution[start] = end == 0 ? 0 : Math.min(solution[start], solution[end - 1] + 1);
                }
            }
        }
        return solution[len - 1];
    }

    public static void main(String[] args) {
        LeetCode132PalindromePartitioningII partitioningII = new LeetCode132PalindromePartitioningII();
        System.out.println(partitioningII.minCut("abb"));
    }
}
