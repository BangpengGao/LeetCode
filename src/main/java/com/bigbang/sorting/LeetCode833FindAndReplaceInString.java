package com.bigbang.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/16
 * @since 1.0.0
 */
public class LeetCode833FindAndReplaceInString {
    /**
     * You are given a 0-indexed string s that you must perform k replacement operations on.
     * The replacement operations are given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.
     * <p>
     * To complete the ith replacement operation:
     * <p>
     * Check if the substring sources[i] occurs at index indices[i] in the original string s.
     * If it does not occur, do nothing.
     * Otherwise if it does occur, replace that substring with targets[i].
     * For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee", then the result of this replacement will be "eeecd".
     * <p>
     * All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing of each other.
     * The testcases will be generated such that the replacements will not overlap.
     * <p>
     * For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be generated because the "ab" and "bc" replacements overlap.
     * Return the resulting string after performing all replacement operations on s.
     * <p>
     * A substring is a contiguous sequence of characters in a string.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
     * Output: "eeebffff"
     * Explanation:
     * "a" occurs at index 0 in s, so we replace it with "eee".
     * "cd" occurs at index 2 in s, so we replace it with "ffff".
     * Example 2:
     * <p>
     * <p>
     * Input: s = "abcd", indices = [0, 2], sources = ["ab","ec"], targets = ["eee","ffff"]
     * Output: "eeecd"
     * Explanation:
     * "ab" occurs at index 0 in s, so we replace it with "eee".
     * "ec" does not occur at index 2 in s, so we do nothing.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 1000
     * k == indices.length == sources.length == targets.length
     * 1 <= k <= 100
     * 0 <= indexes[i] < s.length
     * 1 <= sources[i].length, targets[i].length <= 50
     * s consists of only lowercase English letters.
     * sources[i] and targets[i] consist of only lowercase English letters.
     *
     * @param s
     * @param indices
     * @param sources
     * @param targets
     * @return
     */
    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        //Runtime: 16 ms, faster than 5.39% of Java online submissions for Find And Replace in String.
        //Memory Usage: 42.7 MB, less than 5.09% of Java online submissions for Find And Replace in String.

        List<int[]> list = new ArrayList<>(indices.length);
        for (int i = 0; i < indices.length; i++) {
            list.add(new int[]{indices[i], i});
        }
        Collections.sort(list, Comparator.comparing(i -> -i[0]));
        for (int[] l : list) {
            int indice = l[0], i = l[1];
            String source = sources[i], target = targets[i];
            if (s.substring(indice, indice + source.length()).equals(source))
                s = s.substring(0, indice) + target + s.substring(indice + source.length());
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"ab", "ec"}, targets = {"eee", "ffff"};
        System.out.println(findReplaceString(s, indices, sources, targets));
    }
}
