package com.bigbang.sorting;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/26
 * @ Time 9:59
 */
public class LeetCode354RussianDollEnvelopes {
    /**
     * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
     * <p>
     * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
     * <p>
     * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
     * <p>
     * Note: You cannot rotate an envelope.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
     * Output: 3
     * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
     * Example 2:
     * <p>
     * Input: envelopes = [[1,1],[1,1],[1,1]]
     * Output: 1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= envelopes.length <= 5000
     * envelopes[i].length == 2
     * 1 <= wi, hi <= 104
     *
     * @param envelopes
     * @return
     */
    public static int maxEnvelopesWithLIS(int[][] envelopes) {
        /* 采用最长增序子序列
         * Runtime: 20 ms, faster than 60.74% of Java online submissions for Russian Doll Envelopes.
         * Memory Usage: 47.3 MB, less than 6.61% of Java online submissions for Russian Doll Envelopes.
         */

        if (envelopes.length < 2) return envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[envelopes.length];
        int solution = 0;

        for (int[] envelop : envelopes) {
            // 二分查找
            int left = 0, right = solution, mid = 0;
            while (left < right) {
                mid = left + (right - left) / 2;
                if (dp[mid] < envelop[1]) left = mid + 1;
                else right = mid;
            }

            dp[left] = envelop[1];
            if (left == solution) solution++;
        }
        return solution;
    }

    public static void main(String[] args) {
        int[][] nums = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopesWithLIS(nums));
        int[][] nums1 = {{1, 1}, {1, 1}, {1, 1}};
        System.out.println(maxEnvelopesWithLIS(nums1));
        int[][] nums2 = {{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}};
        System.out.println(maxEnvelopesWithLIS(nums2));
        int[][] nums3 = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        System.out.println(maxEnvelopesWithLIS(nums3));
    }
}
