package com.bigbang.sorting;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/13
 * @since 1.0.0
 */
public class LeetCode767ReorganizeString {
    /**
     * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
     * <p>
     * Return any possible rearrangement of s or return "" if not possible.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "aab"
     * Output: "aba"
     * Example 2:
     * <p>
     * Input: s = "aaab"
     * Output: ""
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 500
     * s consists of lowercase English letters.
     *
     * @param s
     * @return
     */
    public static String reorganizeString(String s) {
        //We construct the resulting string in sequence: at position 0, 2, 4, ... and then 1, 3, 5, ...
        //In this way, we can make sure there is always a gap between the same characters
        //
        //Consider this example: "aaabbbcdd", we will construct the string in this way:
        //
        //a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
        //a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
        //a b a c a _ b _ b // fill in "c" at position 3
        //a b a c a d b d b // fill in "d" at position 5, 7

        //Runtime: 1 ms, faster than 84.69% of Java online submissions for Reorganize String.
        //Memory Usage: 39.1 MB, less than 16.09% of Java online submissions for Reorganize String.

        int[] chars = new int[26];
        for (char c : s.toCharArray())
            chars[c - 'a']++;
        int max = 0, idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > max) {
                max = chars[i];
                idx = i;
            }
        }
        if (max > (s.length() + 1) / 2)
            return "";

        char[] charArr = new char[s.length()];
        int idxTemp = 0;
        while (chars[idx] > 0) {
            charArr[idxTemp] = (char) (idx + 'a');
            idxTemp += 2;
            chars[idx]--;
        }
        for (int i = 0; i < chars.length; i++) {
            while (chars[i] > 0) {
                if (idxTemp >= charArr.length)
                    idxTemp = 1;
                charArr[idxTemp] = (char) (i + 'a');
                idxTemp += 2;
                chars[i]--;
            }
        }
        return String.valueOf(charArr);
    }

    public static void main(String[] args) {
        String s = "vvvlo";
        System.out.println(reorganizeString(s));
        String s1 = "aabbbccddd";
        System.out.println(reorganizeString(s1));
    }
}
