package com.bigbang.sorting;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/24
 * @ Time 10:42
 */
public class LeetCode242ValidAnagram {

    /**
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     * <p>
     * Input: s = "rat", t = "car"
     * Output: false
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length, t.length <= 5 * 104
     * s and t consist of lowercase English letters.
     * <p>
     * <p>
     * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        //Runtime: 7 ms, faster than 32.78% of Java online submissions for Valid Anagram.
        //Memory Usage: 39.4 MB, less than 39.90% of Java online submissions for Valid Anagram.

        char[] charS1 = s.toCharArray();
        Arrays.sort(charS1);
        char[] charS2 = t.toCharArray();
        Arrays.sort(charS2);

        return Arrays.toString(charS1).equals(Arrays.toString(charS2));
    }

    public static boolean isAnagramV2(String s, String t) {
        // 这样修改后，不仅速度慢，占用内存还多
        //Runtime: 12 ms, faster than 19.38% of Java online submissions for Valid Anagram.
        //Memory Usage: 39.5 MB, less than 39.90% of Java online submissions for Valid Anagram.
        if (s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new LinkedHashMap<>();
        Map<Character, Integer> tMap = new LinkedHashMap<>();
        for (char c : s.toCharArray())
            if (sMap.containsKey(c))
                sMap.put(c, sMap.get(c) + 1);
            else
                sMap.put(c, 1);
        for (char c : t.toCharArray())
            if (tMap.containsKey(c))
                tMap.put(c, tMap.get(c) + 1);
            else
                tMap.put(c, 1);
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (!entry.getValue().equals(tMap.get(entry.getKey())))
                return false;
        }
        return true;
    }

    public static boolean isAnagramV3(String s, String t) {
        //网友xhadfasd的解决方案，速度贼快
        //链接地址：https://leetcode.com/problems/valid-anagram/discuss/66484/Accepted-Java-O(n)-solution-in-5-lines
        //Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Anagram.
        //Memory Usage: 39.2 MB, less than 72.28% of Java online submissions for Valid Anagram.
        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) alphabet[c - 'a']++;
        for (char c : t.toCharArray()) alphabet[c - 'a']--;
        for (int a : alphabet) if (a != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagramV2(s, t));
    }
}
