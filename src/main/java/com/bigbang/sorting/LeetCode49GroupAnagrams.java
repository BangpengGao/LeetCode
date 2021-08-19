package com.bigbang.sorting;

import java.util.*;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/19
 * @ Time 14:43
 */
public class LeetCode49GroupAnagrams {
    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * <p>
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * Example 2:
     * <p>
     * Input: strs = [""]
     * Output: [[""]]
     * Example 3:
     * <p>
     * Input: strs = ["a"]
     * Output: [["a"]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] consists of lowercase English letters.
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        //Runtime: 5 ms, faster than 99.09% of Java online submissions for Group Anagrams.
        //Memory Usage: 42.3 MB, less than 57.08% of Java online submissions for Group Anagrams.

        if (strs == null || strs.length == 0) return new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = new char[26];
            for (char c : str.toCharArray()) chars[c - 'a']++;
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) map.put(key, new LinkedList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(s));
    }
}
