package com.bigbang.sorting;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/30
 * @ Time 15:43
 */
public class LeetCode451SortCharactersByFrequency {

    /**
     * Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "tree"
     * Output: "eert"
     * Explanation: 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     * Example 2:
     * <p>
     * Input: s = "cccaaa"
     * Output: "aaaccc"
     * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
     * Note that "cacaca" is incorrect, as the same characters must be together.
     * Example 3:
     * <p>
     * Input: s = "Aabb"
     * Output: "bbAa"
     * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
     * Note that 'A' and 'a' are treated as two different characters.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 5 * 105
     * s consists of English letters and digits.
     *
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        //Runtime: 17 ms, faster than 33.25% of Java online submissions for Sort Characters By Frequency.
        //Memory Usage: 40.2 MB, less than 43.90% of Java online submissions for Sort Characters By Frequency.

        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char c : s.toCharArray())
            characterIntegerMap.put(c, characterIntegerMap.getOrDefault(c, 0) + 1);
        characterIntegerMap = characterIntegerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oleValue, newValue) -> oleValue, LinkedHashMap::new));
        StringBuilder solution = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet())
            for (int c = 0; c < entry.getValue(); c++)
                solution.append(entry.getKey());
        return solution.toString();
    }

    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort(s));
    }
}
