package com.bigbang.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/9/3
 * @ Time 15:06
 */
public class LeetCode524LongestWordInDictionaryThroughDeleting {
    /**
     * Given a string s and a string array dictionary,
     * return the longest string in the dictionary that can be formed by deleting some of the given string characters.
     * If there is more than one possible result,
     * return the longest word with the smallest lexicographical order.
     * If there is no possible result, return the empty string.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
     * Output: "apple"
     * Example 2:
     * <p>
     * Input: s = "abpcplea", dictionary = ["a","b","c"]
     * Output: "a"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 1000
     * 1 <= dictionary.length <= 1000
     * 1 <= dictionary[i].length <= 1000
     * s and dictionary[i] consist of lowercase English letters.
     *
     * @param s
     * @param dictionary
     * @return
     */
    public static String findLongestWord(String s, List<String> dictionary) {
        //Runtime: 53 ms, faster than 5.20% of Java online submissions for Longest Word in Dictionary through Deleting.
        //Memory Usage: 48 MB, less than 18.24% of Java online submissions for Longest Word in Dictionary through Deleting.

        String solution = "";
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? o1.compareTo(o2) : Integer.compare(o2.length(), o1.length());
            }
        });
        for (String d : dictionary) {
            int si = 0, di = 0;
            while (si < s.length() && di < d.length()) {
                if (s.charAt(si) == d.charAt(di)) di++;
                si++;
            }
            if (di == d.length())
                return d;
        }
        return solution;
    }

    public static void main(String[] args) {
        String s = "abce";
        String[] dictionary = {"abe","abc"};
        System.out.println(findLongestWord(s, Arrays.asList(dictionary)));
    }
}
