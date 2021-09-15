package com.bigbang.sorting;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/15
 * @since 1.0.0
 */
public class LeetCode792NumberOfMatchingSubsequences {

    /**
     * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
     * <p>
     * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
     * <p>
     * For example, "ace" is a subsequence of "abcde".
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "abcde", words = ["a","bb","acd","ace"]
     * Output: 3
     * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
     * Example 2:
     * <p>
     * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 5 * 104
     * 1 <= words.length <= 5000
     * 1 <= words[i].length <= 50
     * s and words[i] consist of only lowercase English letters.
     *
     * @param s
     * @param words
     * @return
     */
    public static int numMatchingSubseq(String s, String[] words) {
        //Runtime: 56 ms, faster than 77.72% of Java online submissions for Number of Matching Subsequences.
        //Memory Usage: 40.6 MB, less than 77.07% of Java online submissions for Number of Matching Subsequences.

        Map<Character, Deque<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new LinkedList<String>());
        }
        for (String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }

        int count = 0;
        for (char c : s.toCharArray()) {
            Deque<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(s, words));

        String s1 = "dsahjpjauf";
        String[] words1 = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        System.out.println(numMatchingSubseq(s1, words1));

        String s2 = "btovxbkumc";
        String[] word2 = {"btovxbku", "to", "zueoxxxjme", "yjkclbkbtl"};
        System.out.println(numMatchingSubseq(s2, word2));
    }
}
