package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/24
 * @since 1.0.0
 */
public class LeetCode44WildcardMatching {
    /**
     * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * The matching should cover the entire input string (not partial).
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: s = "aa", p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     * <p>
     * Example 2:
     * Input: s = "aa", p = "*"
     * Output: true
     * Explanation: '*' matches any sequence.
     * <p>
     * Example 3:
     * Input: s = "cb", p = "?a"
     * Output: false
     * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
     * <p>
     * Example 4:
     * Input: s = "adceb", p = "*a*b"
     * Output: true
     * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
     * <p>
     * Example 5:
     * Input: s = "acdcb", p = "a*c?b"
     * Output: false
     * <p>
     * <p>
     * Constraints:
     * 0 <= s.length, p.length <= 2000
     * s contains only lowercase English letters.
     * p contains only lowercase English letters, '?' or '*'.
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        //Runtime: 26 ms, faster than 55.39% of Java online submissions for Wildcard Matching.
        //Memory Usage: 39.1 MB, less than 86.97% of Java online submissions for Wildcard Matching.

        boolean[][] table = new boolean[s.length() + 1][p.length() + 1];
        table[s.length()][p.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) != '*')
                break;
            else
                table[s.length()][i] = true;
        }

        for (int si = s.length() - 1; si >= 0; si--) {
            for (int pi = p.length() - 1; pi >= 0; pi--) {
                if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')
                    table[si][pi] = table[si + 1][pi + 1];
                else if (p.charAt(pi) == '*')
                    table[si][pi] = table[si + 1][pi] || table[si][pi + 1];
                else
                    table[si][pi] = false;
            }
        }
        return table[0][0];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("acdcb", "a*c?b"));
    }
}
