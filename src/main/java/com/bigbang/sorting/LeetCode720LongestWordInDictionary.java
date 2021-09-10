package com.bigbang.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/10
 * @since 1.0.0
 */
public class LeetCode720LongestWordInDictionary {
    /**
     * Given an array of strings words representing an English Dictionary,
     * return the longest word in words that can be built one character at a time by other words in words.
     * <p>
     * If there is more than one possible answer, return the longest word with the smallest lexicographical order.
     * If there is no answer, return the empty string.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: words = ["w","wo","wor","worl","world"]
     * Output: "world"
     * Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
     * Example 2:
     * <p>
     * Input: words = ["a","banana","app","appl","ap","apply","apple"]
     * Output: "apple"
     * Explanation: Both "apply" and "apple" can be built from other words in the dictionary.
     * However, "apple" is lexicographically smaller than "apply".
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= words.length <= 1000
     * 1 <= words[i].length <= 30
     * words[i] consists of lowercase English letters.
     *
     * @param words
     * @return
     */
    public static String longestWord(String[] words) {
        //暴力解决
        //Runtime: 5 ms, faster than 99.63% of Java online submissions for Longest Word in Dictionary.
        //Memory Usage: 39.3 MB, less than 68.14% of Java online submissions for Longest Word in Dictionary.
        String ans = "";
        Set<String> wordset = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) ans = word;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(words));

        String[] words1 = {"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"};
        System.out.println(longestWord(words1));
    }
}
