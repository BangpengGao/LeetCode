package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/30
 * @since 1.0.0
 */
public class LeetCode97InterleavingString {
    /**
     * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
     * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
     * Note: a + b is the concatenation of strings a and b.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * Output: true
     * <p>
     * Example 2:
     * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * Output: false
     * <p>
     * Example 3:
     * Input: s1 = "", s2 = "", s3 = ""
     * Output: true
     * <p>
     * <p>
     * Constraints:
     * 0 <= s1.length, s2.length <= 100
     * 0 <= s3.length <= 200
     * s1, s2, and s3 consist of lowercase English letters.
     * <p>
     * <p>
     * Follow up: Could you solve it using only O(s2.length) additional memory space?
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        // dp
        // Runtime: 4 ms, faster than 63.10% of Java online submissions for Interleaving String.
        // Memory Usage: 37.4 MB, less than 73.92% of Java online submissions for Interleaving String.
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aa",
                "ab",
                "aaab"));
    }
}
