package com.bigbang.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/13
 * @since 1.0.0
 */
public class LeetCode140WordBreakII {
    /**
     * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word.
     * Return all such possible sentences in any order.
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
     * Output: ["cats and dog","cat sand dog"]
     * <p>
     * Example 2:
     * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
     * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
     * Explanation: Note that you are allowed to reuse a dictionary word.
     * <p>
     * Example 3:
     * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * Output: []
     * <p>
     * Constraints:
     * 1 <= s.length <= 20
     * 1 <= wordDict.length <= 1000
     * 1 <= wordDict[i].length <= 10
     * s and wordDict[i] consist of only lowercase English letters.
     * All the strings of wordDict are unique.
     *
     * @param s
     * @param wordDict
     * @return
     */
    List<String> solution;

    public List<String> wordBreak(String s, List<String> wordDict) {
        //典型的动态规划
        //Runtime: 3 ms, faster than 65.22% of Java online submissions for Word Break II.
        //Memory Usage: 39.3 MB, less than 25.53% of Java online submissions for Word Break II.

        solution = new ArrayList<>();
        breakWord(s, wordDict, new ArrayList<String>(), 0);
        return solution;
    }

    public void breakWord(String s, List<String> workDict, List<String> builder, int start) {
        if (start >= s.length()) {
            solution.add(builder.stream().collect(Collectors.joining(" ")));
        }
        for (int end = start; end < s.length(); end++) {
            if (workDict.contains(s.substring(start, end + 1))) {
                builder.add(s.substring(start, end + 1));
                breakWord(s, workDict, builder, end + 1);
                builder.remove(builder.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode140WordBreakII breakII = new LeetCode140WordBreakII();
        String s = "aaaaaaa";
        String[] dict = {"aaa", "aaaa", "and", "sand", "dog"};
        System.out.println(breakII.wordBreak(s, Arrays.asList(dict)));
    }
}
