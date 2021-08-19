package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/21
 */

import java.util.TreeSet;

public class LastSubstringInLexicographicalOrder {
    /**
     * 1163. Last Substring in Lexicographical Order
     * Hard
     * <p>
     * Given a string s, return the last substring of s in lexicographical order.
     * <p>
     * Example 1:
     * <p>
     * Input: "abab"
     * Output: "bab"
     * Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
     * Example 2:
     * <p>
     * Input: "leetcode"
     * Output: "tcode"
     * <p>
     * Note:
     * 1 <= s.length <= 4 * 10^5
     * s contains only lowercase English letters.
     *
     * @param s
     * @return
     */
    public String solution1(String s) {
        int i = 0, j = 1, offset = 0, len = s.length();
        while (i + offset < len && j + offset < len) {
            char c = s.charAt(i + offset), d = s.charAt(j + offset);
            if (c == d) {
                ++offset;
            }else {
                if (c < d)  { i += offset + 1; } // chars in [i, ..., i + offset] <= charAt(i) == charAt(j)
                else { j += offset + 1; } // c > d, chars in [j, ..., j + offset] <= charAt(i) == charAt(j)
                if (i == j) { ++i; } // avoid duplicate start indices.
                offset = 0; // reset offset to 0.
            }
        }
        return s.substring(Math.min(i, j));
    }

    /**
     * 1、Traverse the input string reversely, encode all suffices and compare them and update max and the corresponding index. e.g., for "bba",
     * radix is 2, and we have suffices "a", "ba", "bba" and their encoding are as follows:
     * 0, 0 + 1 * 2 = 2, 0 + 1 * 2 + 1 * 2 * 2 = 6
     *
     * 2、We can use TreeSet.headSet(key).size() to get indices of corresponding characters.
     */
    public String solution2(String s){
        TreeSet<Character> ts = new TreeSet<>();
        for (int i = 0; i < s.length(); ++i)
            ts.add(s.charAt(i));
        int radix = ts.size(), lo = 0;
        double max = 0d, cur = 0d;
        for (int i = s.length() - 1; i >= 0; --i) {
            cur = ts.headSet(s.charAt(i)).size() + cur / radix;
            if (max <= cur) {
                max = cur;
                lo = i;
            }
        }
        return s.substring(lo);
    }
}
