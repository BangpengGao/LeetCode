package com.bigbang.sorting;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/17
 * @since 1.0.0
 */
public class LeetCode899OrderlyQueue {
    /**
     * You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string..
     * Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: s = "cba", k = 1
     * Output: "acb"
     * Explanation:
     * In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
     * In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".
     * <p>
     * Example 2:
     * Input: s = "baaca", k = 3
     * Output: "aaabc"
     * Explanation:
     * In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
     * In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".
     * <p>
     * <p>
     * Constraints:
     * 1 <= k <= s.length <= 1000
     * s consist of lowercase English letters.
     *
     * @param s
     * @param k
     * @return
     */
    public static String orderlyQueue(String s, int k) {
        //Runtime: 9 ms, faster than 5.74% of Java online submissions for Orderly Queue.
        //Memory Usage: 41.4 MB, less than 5.15% of Java online submissions for Orderly Queue.

        if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); i++) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            return ans;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        String s = "baaca";
        int k = 1;
        System.out.println(orderlyQueue(s, k));
    }
}
