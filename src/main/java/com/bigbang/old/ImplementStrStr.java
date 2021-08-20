package com.bigbang.old.learn;
/*
 * @ Created with IntelliJ IDEA
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/12/24
 * @ Time 16:03
 */

public class ImplementStrStr {
    /**
     * 28. Implement strStr()
     * Easy
     * <p>
     * Implement strStr().
     * <p>
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * <p>
     * Example 1:
     * <p>
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     * Example 2:
     * <p>
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     * Clarification:
     * <p>
     * What should we return when needle is an empty string? This is a great question to ask during an interview.
     * For the purpose of this problem, we will return 0 when needle is an empty string.
     * This is consistent to C's strstr() and Java's indexOf().
     *
     * @param haystack
     * @param needle
     * @return
     */

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement strStr().
    // Memory Usage: 37.6 MB, less than 69.46% of Java online submissions for Implement strStr().

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(strStr("aaa", "b"));
    }
}
