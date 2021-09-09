package com.bigbang.sorting;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/9
 * @since 1.0.0
 */
public class LeetCode646MaximumLengthOfPairChain {
    /**
     * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
     * <p>
     * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
     * <p>
     * Return the length longest chain which can be formed.
     * <p>
     * You do not need to use up all the given intervals. You can select pairs in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: pairs = [[1,2],[2,3],[3,4]]
     * Output: 2
     * Explanation: The longest chain is [1,2] -> [3,4].
     * Example 2:
     * <p>
     * Input: pairs = [[1,2],[7,8],[4,5]]
     * Output: 3
     * Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == pairs.length
     * 1 <= n <= 1000
     * -1000 <= lefti < righti <= 1000
     *
     * @param pairs
     * @return
     */
    public static int findLongestChain(int[][] pairs) {
        // 贪心算法
        // Runtime: 14 ms, faster than 56.90% of Java online submissions for Maximum Length of Pair Chain.
        // Memory Usage: 51.3 MB, less than 22.34% of Java online submissions for Maximum Length of Pair Chain.

        Arrays.sort(pairs, (o1, o2) -> (o1[1] - o2[1]));
        int solution = 1, temp = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > temp) {
                solution++;
                temp = pairs[i][1];
            }
        }
        return solution;
    }

    public static void main(String[] args) {

    }
}
