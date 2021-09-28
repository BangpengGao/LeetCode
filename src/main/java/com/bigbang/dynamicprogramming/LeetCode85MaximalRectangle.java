package com.bigbang.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/28
 * @since 1.0.0
 */
public class LeetCode85MaximalRectangle {
    /**
     * Given a rows x cols binary matrix filled with 0's and 1's,
     * find the largest rectangle containing only 1's and return its area.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * Output: 6
     * Explanation: The maximal rectangle is shown in the above picture.
     * <p>
     * Example 2:
     * Input: matrix = []
     * Output: 0
     * <p>
     * Example 3:
     * Input: matrix = [["0"]]
     * Output: 0
     * <p>
     * Example 4:
     * Input: matrix = [["1"]]
     * Output: 1
     * <p>
     * Example 5:
     * Input: matrix = [["0","0"]]
     * Output: 0
     * <p>
     * Constraints:
     * rows == matrix.length
     * cols == matrix[i].length
     * 0 <= row, cols <= 200
     * matrix[i][j] is '0' or '1'.
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        /*
         * Runtime: 2 ms, faster than 99.93% of Java online submissions for Maximal Rectangle.
         * Memory Usage: 42.3 MB, less than 46.95% of Java online submissions for Maximal Rectangle.
         *
         * 举例理解整体思想
         * row 0: 0 0 0 1 0 0 0
         * height: 0 0 0 1 0 0 0
         * left: 0 0 0 3 0 0 0
         * right 7 7 7 4 7 7 7
         *
         * row 1: 0 0 1 1 1 0 0
         * height: 0 0 1 2 1 0 0
         * left: 0 0 2 3 2 0 0
         * right: 7 7 5 4 5 7 7
         *
         * row 2: 0 1 1 1 1 1 0
         * height: 0 1 2 3 2 1 0
         * left: 0 1 2 3 2 1 0
         * right: 7 6 5 4 5 6 7
         */
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
            for (int j = 0; j < n; j++)
                solution = Math.max(solution, (right[j] - left[j]) * height[j]);
        }
        return solution;
    }

    public static void main(String[] args) {
        char[][] chars = {{'1'}};
        System.out.println(maximalRectangle(chars));
    }
}
