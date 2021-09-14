package com.bigbang.sorting;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/13
 * @since 1.0.0
 */
public class LeetCode791CustomSortString {

    /**
     * You are given two strings order and s. All the words of order are unique and were sorted in some custom order previously.
     * <p>
     * Permute the characters of s so that they match the order that order was sorted. More specifically,
     * if a character x occurs before a character y in order, then x should occur before y in the permuted string.
     * <p>
     * Return any permutation of s that satisfies this property.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: order = "cba", s = "abcd"
     * Output: "cbad"
     * Explanation:
     * "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
     * Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
     * Example 2:
     * <p>
     * Input: order = "cbafg", s = "abcd"
     * Output: "cbad"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= order.length <= 26
     * 1 <= s.length <= 200
     * order and s consist of lowercase English letters.
     * All the characters of order are unique.
     *
     * @param order
     * @param s
     * @return
     */
    public static String customSortString(String order, String s) {
        //采用桶排序
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Custom Sort String.
        //Memory Usage: 37 MB, less than 74.80% of Java online submissions for Custom Sort String.

        int[] bucket = new int[order.length()];
        StringBuilder solution = new StringBuilder();
        for (char c : s.toCharArray()) {
            int idx = order.indexOf(String.valueOf(c));
            if (idx >= 0)
                bucket[idx] += 1;
            else
                solution.append(c);
        }

        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                solution.append(order.charAt(i));
                bucket[i]--;
            }
        }

        return solution.toString();
    }

    public static void main(String[] args) {
        String order = "cbafg", s = "abcd";
        System.out.println(customSortString(order, s));
    }
}
