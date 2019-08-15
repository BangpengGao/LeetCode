package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/7/25
 */

public class ReachingPoints {

    /**
     * 780. Reaching Points
     * Hard
     * A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).
     * Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.
     * <p>
     * Examples:
     * Input: sx = 1, sy = 1, tx = 3, ty = 5
     * Output: True
     * Explanation:
     * One series of moves that transforms the starting point to the target is:
     * (1, 1) -> (1, 2)
     * (1, 2) -> (3, 2)
     * (3, 2) -> (3, 5)
     * Input: sx = 1, sy = 1, tx = 2, ty = 2
     * Output: False
     * Input: sx = 1, sy = 1, tx = 1, ty = 1
     * Output: True
     * <p>
     * Note:
     * sx, sy, tx, ty will all be integers in the range [1, 10^9].
     */
    public boolean solution(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty)
            if (tx < ty) ty %= tx;
            else tx %= ty;
        return sx == tx && sy <= ty && (ty - sy) % sx == 0 ||
                sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }
}