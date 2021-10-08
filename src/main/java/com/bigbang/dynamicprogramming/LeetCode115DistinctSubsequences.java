package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/8
 * @since 1.0.0
 */
public class LeetCode115DistinctSubsequences {
    /**
     * Given two strings s and t, return the number of distinct subsequences of s which equals t.
     * A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters
     * without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
     * It is guaranteed the answer fits on a 32-bit signed integer.
     * <p>
     * <p>
     * Example 1:
     * Input: s = "rabbbit", t = "rabbit"
     * Output: 3
     * Explanation:
     * As shown below, there are 3 ways you can generate "rabbit" from S.
     * rabbbit
     * rabbbit
     * rabbbit
     * <p>
     * Example 2:
     * Input: s = "babgbag", t = "bag"
     * Output: 5
     * Explanation:
     * As shown below, there are 5 ways you can generate "bag" from S.
     * babgbag
     * babgbag
     * babgbag
     * babgbag
     * babgbag
     * <p>
     * <p>
     * Constraints:
     * 1 <= s.length, t.length <= 1000
     * s and t consist of English letters.
     *
     * @param s
     * @param t
     * @return
     */
    public static int numDistinct(String s, String t) {
        //动态规划实现方案
        //Runtime: 15 ms, faster than 35.42% of Java online submissions for Distinct Subsequences.
        //Memory Usage: 46.3 MB, less than 8.86% of Java online submissions for Distinct Subsequences.

        int[][] table = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++)
            table[0][i] = 1;

        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j))
                    table[i + 1][j + 1] = table[i][j] + table[i + 1][j];
                else
                    table[i + 1][j + 1] = table[i + 1][j];
            }
        }
        return table[t.length()][s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
    }
}
