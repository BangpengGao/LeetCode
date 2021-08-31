package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/31
 * @ Time 10:58
 */
public class LeetCode452MinimumNumberOfArrows2BurstBalloons {
    /**
     * There are some spherical balloons spread in two-dimensional space.
     * For each balloon, provided input is the start and end coordinates of the horizontal diameter.
     * Since it's horizontal, y-coordinates don't matter,
     * and hence the x-coordinates of start and end of the diameter suffice.
     * The start is always smaller than the end.
     * <p>
     * An arrow can be shot up exactly vertically from different points along the x-axis.
     * A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
     * There is no limit to the number of arrows that can be shot. An arrow once shot keeps traveling up infinitely.
     * <p>
     * Given an array points where points[i] = [xstart, xend],
     * return the minimum number of arrows that must be shot to burst all balloons.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: points = [[10,16],[2,8],[1,6],[7,12]]
     * Output: 2
     * Explanation: One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
     * Example 2:
     * <p>
     * Input: points = [[1,2],[3,4],[5,6],[7,8]]
     * Output: 4
     * Example 3:
     * <p>
     * Input: points = [[1,2],[2,3],[3,4],[4,5]]
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= points.length <= 105
     * points[i].length == 2
     * -231 <= xstart < xend <= 231 - 1
     *
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        //Runtime: 129 ms, faster than 5.04% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
        //Memory Usage: 114.9 MB, less than 5.27% of Java online submissions for Minimum Number of Arrows to Burst Balloons.

        if (points.length == 0)
            return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrowPos = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0])
                continue;
            count++;
            arrowPos = points[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{7, 10}, {1, 5}, {3, 6}, {2, 4}, {1, 4}};
        System.out.println(findMinArrowShots(points));
    }
}
