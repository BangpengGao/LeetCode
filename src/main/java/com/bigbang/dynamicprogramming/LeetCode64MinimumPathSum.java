package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/26
 * @since 1.0.0
 */
public class LeetCode64MinimumPathSum {
    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
     * which minimizes the sum of all numbers along its path.
     * Note: You can only move either down or right at any point in time.
     * <p>
     * <p>
     * Example 1:
     * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
     * Output: 7
     * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     * <p>
     * Example 2:
     * Input: grid = [[1,2,3],[4,5,6]]
     * Output: 12
     * <p>
     * Constraints:
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 100
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        //动态规划
        //Runtime: 2 ms, faster than 82.79% of Java online submissions for Minimum Path Sum.
        //Memory Usage: 41.6 MB, less than 73.37% of Java online submissions for Minimum Path Sum.

        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (j > 0)
                        grid[i][j] += grid[i][j - 1];
                    else if (i > 0)
                        grid[i][j] += grid[i - 1][j];
                } else
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(grid));
    }
}
