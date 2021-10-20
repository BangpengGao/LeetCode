package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/20
 * @since 1.0.0
 */
public class LeetCode174DungeonGame {
    /**
     * The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon.
     * The dungeon consists of m x n rooms laid out in a 2D grid.
     * Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.
     * The knight has an initial health point represented by a positive integer.
     * If at any point his health point drops to 0 or below, he dies immediately.
     * Some of the rooms are guarded by demons (represented by negative integers),
     * so the knight loses health upon entering these rooms;
     * other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).
     * To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
     * Return the knight's minimum initial health so that he can rescue the princess.
     * Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
     * Output: 7
     * Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
     * <p>
     * Example 2:
     * Input: dungeon = [[0]]
     * Output: 1
     * <p>
     * Constraints:
     * m == dungeon.length
     * n == dungeon[i].length
     * 1 <= m, n <= 200
     * -1000 <= dungeon[i][j] <= 1000
     *
     * @param dungeon
     * @return
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        //Runtime: 5 ms, faster than 10.90% of Java online submissions for Dungeon Game.
        //Memory Usage: 41.3 MB, less than 19.54% of Java online submissions for Dungeon Game.

        int x = dungeon.length, y = dungeon[0].length;
        int[][] table = new int[x][y];
        table[x - 1][y - 1] = Math.max(1 - dungeon[x - 1][y - 1], 1);

        for (int i = x - 2; i >= 0; i--)
            table[i][y - 1] = Math.max(table[i + 1][y - 1] - dungeon[i][y - 1], 1);

        for (int i = y - 2; i >= 0; i--)
            table[x - 1][i] = Math.max(table[x - 1][i + 1] - dungeon[x - 1][i], 1);

        for (int i = x - 2; i >= 0; i--) {
            for (int j = y - 2; j >= 0; j--) {
                int right = Math.max(table[i + 1][j] - dungeon[i][j], 1);
                int down = Math.max(table[i][j + 1] - dungeon[i][j], 1);
                table[i][j] = Math.min(right, down);
            }
        }
        return table[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(dungeon));
    }
}
