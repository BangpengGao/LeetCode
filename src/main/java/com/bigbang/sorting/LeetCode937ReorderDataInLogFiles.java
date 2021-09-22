package com.bigbang.sorting;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/22
 * @since 1.0.0
 */
public class LeetCode937ReorderDataInLogFiles {
    /**
     * You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
     * There are two types of logs:
     * Letter-logs: All words (except the identifier) consist of lowercase English letters.
     * Digit-logs: All words (except the identifier) consist of digits.
     * Reorder these logs so that:
     * The letter-logs come before all digit-logs.
     * The letter-logs are sorted lexicographically by their contents.
     * If their contents are the same, then sort them lexicographically by their identifiers.
     * The digit-logs maintain their relative ordering.
     * Return the final order of the logs.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
     * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
     * Explanation:
     * The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
     * The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
     * <p>
     * Example 2:
     * Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
     * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
     * <p>
     * <p>
     * Constraints:
     * 1 <= logs.length <= 100
     * 3 <= logs[i].length <= 100
     * All the tokens of logs[i] are separated by a single space.
     * logs[i] is guaranteed to have an identifier and at least one word after the identifier.
     *
     * @param logs
     * @return
     */
    public static String[] reorderLogFiles(String[] logs) {
        //Runtime: 17 ms, faster than 12.48% of Java online submissions for Reorder Data in Log Files.
        //Memory Usage: 40 MB, less than 36.76% of Java online submissions for Reorder Data in Log Files.

        Deque<String> digit = new LinkedList<>();
        List<String> letter = new LinkedList<>();
        for (String log : logs) {
            String[] arr = log.split(" ");
            if (arr[1].matches("[0-9]+")) {
                digit.add(log);
            } else {
                letter.add(log);
            }
        }
        letter = letter.stream().sorted(Comparator.comparing(s -> {
            String[] arr = s.split(" ");
            return arr[0];
        })).sorted(Comparator.comparing(s -> {
            int idx = s.indexOf(" ");
            return s.substring(idx);
        })).collect(Collectors.toList());
        letter.addAll(digit);
        return letter.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"};
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }
}
