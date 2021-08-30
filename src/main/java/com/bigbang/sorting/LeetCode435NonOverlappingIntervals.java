package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/30
 * @ Time 14:18
 */
public class LeetCode435NonOverlappingIntervals {
    /**
     * Given an array of intervals intervals where intervals[i] = [starti, endi],
     * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * Output: 1
     * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
     * Example 2:
     * <p>
     * Input: intervals = [[1,2],[1,2],[1,2]]
     * Output: 2
     * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
     * Example 3:
     * <p>
     * Input: intervals = [[1,2],[2,3]]
     * Output: 0
     * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= intervals.length <= 105
     * intervals[i].length == 2
     * -5 * 104 <= starti < endi <= 5 * 104
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        //Runtime: 48 ms, faster than 30.49% of Java online submissions for Non-overlapping Intervals.
        //Memory Usage: 96.3 MB, less than 41.11% of Java online submissions for Non-overlapping Intervals.

        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int removed = 0, preEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < preEnd) {
                preEnd = Math.min(preEnd, intervals[i][1]);
                removed++;
            } else
                preEnd = intervals[i][1];
        }
        return removed;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
