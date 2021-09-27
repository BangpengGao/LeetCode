package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/27
 * @since 1.0.0
 */
public class LeetCode72EditDistance {
    /**
     * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
     * You have the following three operations permitted on a word:
     * Insert a character
     * Delete a character
     * Replace a character
     * <p>
     * <p>
     * Example 1:
     * Input: word1 = "horse", word2 = "ros"
     * Output: 3
     * Explanation:
     * horse -> rorse (replace 'h' with 'r')
     * rorse -> rose (remove 'r')
     * rose -> ros (remove 'e')
     * <p>
     * Example 2:
     * Input: word1 = "intention", word2 = "execution"
     * Output: 5
     * Explanation:
     * intention -> inention (remove 't')
     * inention -> enention (replace 'i' with 'e')
     * enention -> exention (replace 'n' with 'x')
     * exention -> exection (replace 'n' with 'c')
     * exection -> execution (insert 'u')
     * <p>
     * Constraints:
     * 0 <= word1.length, word2.length <= 500
     * word1 and word2 consist of lowercase English letters.
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        //Runtime: 4 ms, faster than 91.06% of Java online submissions for Edit Distance.
        //Memory Usage: 39.1 MB, less than 60.51% of Java online submissions for Edit Distance.

        int len1 = word1.length(), len2 = word2.length();
        int[][] table = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++)
            table[i][0] = i;
        for (int i = 1; i < len2; i++)
            table[0][i] = i;

        for (int w1 = 0; w1 < len1; w1++) {
            for (int w2 = 0; w2 < len2; w2++) {
                if (word1.charAt(w1) == word2.charAt(w2))
                    table[w1 + 1][w2 + 1] = table[w1][w2];
                else {
                    int a = table[w1][w2], b = table[w1 + 1][w2], c = table[w1][w2 + 1];
                    table[w1 + 1][w2 + 1] = a < b ? (Math.min(a, c)) : (Math.min(b, c));
                    table[w1 + 1][w2 + 1]++;
                }
            }
        }
        return table[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }
}
