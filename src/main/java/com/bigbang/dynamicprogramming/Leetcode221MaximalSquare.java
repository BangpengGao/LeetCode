package com.bigbang.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/29
 * @since 1.0.0
 */
public class Leetcode221MaximalSquare {
    /**
     * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * Output: 4
     * <p>
     * Example 2:
     * Input: matrix = [["0","1"],["1","0"]]
     * Output: 1
     * <p>
     * Example 3:
     * Input: matrix = [["0"]]
     * Output: 0
     * <p>
     * Constraints:
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 300
     * matrix[i][j] is '0' or '1'.
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        //参考LeetCode 85. Maximal Rectangle
        //Runtime: 3 ms, faster than 99.05% of Java online submissions for Maximal Square.
        //Memory Usage: 42.8 MB, less than 48.55% of Java online submissions for Maximal Square.

        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, solution = 0;
        int[] left = new int[n], right = new int[n], height = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                    height[j] = 0;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], curRight);
                else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for (int j = 0; j < n; j++) {
                int square = right[j] - left[j] > height[j] ? height[j] * height[j] : (right[j] - left[j]) * (right[j] - left[j]);
                solution = Math.max(solution, square);
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        char[][] chars = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(chars));
    }
}
