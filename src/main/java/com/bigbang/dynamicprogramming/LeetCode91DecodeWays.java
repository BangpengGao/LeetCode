package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/29
 * @since 1.0.0
 */
public class LeetCode91DecodeWays {
    /**
     * A message containing letters from A-Z can be encoded into numbers using the following mapping:
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways).
     * For example, "11106" can be mapped into:
     * "AAJF" with the grouping (1 1 10 6)
     * "KJF" with the grouping (11 10 6)
     * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
     * Given a string s containing only digits, return the number of ways to decode it.
     * The answer is guaranteed to fit in a 32-bit integer.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: s = "12"
     * Output: 2
     * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
     * <p>
     * Example 2:
     * Input: s = "226"
     * Output: 3
     * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     * <p>
     * Example 3:
     * Input: s = "0"
     * Output: 0
     * Explanation: There is no character that is mapped to a number starting with 0.
     * The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
     * Hence, there are no valid ways to decode this since all digits need to be mapped.
     * <p>
     * Example 4:
     * Input: s = "06"
     * Output: 0
     * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
     * <p>
     * <p>
     * Constraints:
     * 1 <= s.length <= 100
     * s contains only digits and may contain leading zero(s).
     *
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        //动态规划，dp constant space
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode Ways.
        //Memory Usage: 37.1 MB, less than 88.86% of Java online submissions for Decode Ways.
        int dp1 = 1, dp2 = 0, n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            int dp = s.charAt(i) == '0' ? 0 : dp1;
            if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                dp += dp2;
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("11106"));
    }
}
