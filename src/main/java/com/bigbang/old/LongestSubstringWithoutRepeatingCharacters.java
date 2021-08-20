package com.bigbang.old;

import java.util.HashMap;

/*
Given a string, find the length of the longest substring without repeating characters.
example:
input:'abcabcbb'
output:3
explanation:The answer is 'abc', which the length is 3.
*/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (h.containsKey(s.charAt(i))) {
                j = Math.max(j, h.get(s.charAt(i)) + 1);
            }
            h.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}