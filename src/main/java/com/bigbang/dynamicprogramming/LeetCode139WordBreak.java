package com.bigbang.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/13
 * @since 1.0.0
 */
public class LeetCode139WordBreak {
    /**
     * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: s = "leetcode", wordDict = ["leet","code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * <p>
     * Example 2:
     * Input: s = "applepenapple", wordDict = ["apple","pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     * Note that you are allowed to reuse a dictionary word.
     * <p>
     * Example 3:
     * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * Output: false
     * <p>
     * <p>
     * Constraints:
     * 1 <= s.length <= 300
     * 1 <= wordDict.length <= 1000
     * 1 <= wordDict[i].length <= 20
     * s and wordDict[i] consist of only lowercase English letters.
     * All the strings of wordDict are unique.
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        //Runtime: 26 ms, faster than 5.28% of Java online submissions for Word Break.
        //Memory Usage: 44.1 MB, less than 14.32% of Java online submissions for Word Break.

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

    public static void main(String[] args) {
        String s = "aaaaaaa";
        String[] dict = {"aaa", "aaaa", "and", "sand", "dog"};
        LeetCode139WordBreak wordBreak = new LeetCode139WordBreak();
        System.out.println(wordBreak.wordBreak(s, Arrays.asList(dict)));
    }
}
