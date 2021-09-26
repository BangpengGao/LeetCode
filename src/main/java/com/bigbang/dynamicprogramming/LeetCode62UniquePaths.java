package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/26
 * @since 1.0.0
 */
public class LeetCode62UniquePaths {
    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * How many possible unique paths are there?
     * <p>
     * <p>
     * Example 1:
     * Input: m = 3, n = 7
     * Output: 28
     * <p>
     * Example 2:
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation:
     * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Down -> Down
     * 2. Down -> Down -> Right
     * 3. Down -> Right -> Down
     * <p>
     * Example 3:
     * Input: m = 7, n = 3
     * Output: 28
     * <p>
     * Example 4:
     * Input: m = 3, n = 3
     * Output: 6
     * <p>
     * <p>
     * Constraints:
     * 1 <= m, n <= 100
     * It's guaranteed that the answer will be less than or equal to 2 * 109.
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        // Total permutations = (m+n)! / (m! * n!)
        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
        // Memory Usage: 35.5 MB, less than 91.05% of Java online submissions for Unique Paths.

        if (m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if (m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for (int i = m + 1; i <= m + n; i++, j++) {       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }

        return (int) res;
    }

    public static int uniquePathsV2(int m, int n) {
        // 动态规划
        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
        // Memory Usage: 35.9 MB, less than 62.60% of Java online submissions for Unique Paths.

        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    map[i][j] = 1;
                else
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
        System.out.println(uniquePathsV2(3, 3));
    }
}
