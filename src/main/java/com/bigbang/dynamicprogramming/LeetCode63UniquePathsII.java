package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/26
 * @since 1.0.0
 */
public class LeetCode63UniquePathsII {
    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * An obstacle and space is marked as 1 and 0 respectively in the grid.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * Output: 2
     * Explanation: There is one obstacle in the middle of the 3x3 grid above.
     * There are two ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down -> Down
     * 2. Down -> Down -> Right -> Right
     * <p>
     * Example 2:
     * Input: obstacleGrid = [[0,1],[0,0]]
     * Output: 1
     * <p>
     * <p>
     * Constraints:
     * m == obstacleGrid.length
     * n == obstacleGrid[i].length
     * 1 <= m, n <= 100
     * obstacleGrid[i][j] is 0 or 1.
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //动态规划
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
        //Memory Usage: 37.2 MB, less than 91.06% of Java online submissions for Unique Paths II.

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;

        obstacleGrid[0][0] = 1;

        for (int i = 1; i < m; i++)
            obstacleGrid[i][0] = obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1 ? 1 : 0;

        for (int i = 1; i < n; i++)
            obstacleGrid[0][i] = obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1 ? 1 : 0;


        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (obstacleGrid[i][j] != 0)
                    obstacleGrid[i][j] = 0;
                else
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];

        return obstacleGrid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
