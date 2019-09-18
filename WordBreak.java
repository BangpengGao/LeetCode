package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/9/5
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WordBreak {
    /**
     * 139. Word Break
     * Medium
     * <p>
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     * <p>
     * Note:
     * <p>
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     * <p>
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * Example 2:
     * <p>
     * Input: s = "applepenapple", wordDict = ["apple", "pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     * Note that you are allowed to reuse a dictionary word.
     * Example 3:
     * <p>
     * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * Output: false
     */

    // TLE（Time Limit Exceeded）
    public static boolean solution1(String s, List<String> wordDict) {
        return match(s, 0, 1, wordDict);
    }

    private static boolean match(String s, int start, int end, List<String> wordDict) {
        if (end == s.length() && wordDict.contains(s.substring(start)))
            return true;
        for (int i = end; i <= s.length(); i++) {
            String temp = s.substring(start, i);
            if (i == s.length() && !wordDict.contains(temp)) return false;
            if ((i == s.length() && wordDict.contains(temp)) || (wordDict.contains(temp) && match(s, i, i + 1, wordDict)))
                return true;
        }
        return false;
    }

    // 动态规划
    public static boolean solution2(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    public static Date parseDate(String dateString, String timeFormat) {
        if (dateString != null && dateString.trim().length() != 0) {
            SimpleDateFormat format = new SimpleDateFormat(timeFormat);

            try {
                Date date = format.parse(dateString.trim());
                return date;
            } catch (Exception var4) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
//        List<String> words = new ArrayList<>();
//        words.add("apple");
//        words.add("pen");
//        System.out.println(solution1("applepenapple", words));
        System.out.println(parseDate("2019-09-08 21:57:00.0", "yyyy-MM-dd HH:mm:ss"));
    }
}
