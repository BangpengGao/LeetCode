package com.bigbang.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/19
 * @ Time 15:46
 */
public class LeetCode56MergeIntervals {
    /**
     * Given an array of intervals where intervals[i] = [starti, endi],
     * merge all overlapping intervals,
     * and return an array of the non-overlapping intervals that cover all the intervals in the input.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     * Example 2:
     * <p>
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 104
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        //Runtime: 5 ms, faster than 95.11% of Java online submissions for Merge Intervals.
        //Memory Usage: 41.8 MB, less than 39.70% of Java online submissions for Merge Intervals.

        if (intervals.length <= 0) return intervals;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> solution = new LinkedList<>();
        int[] tempIntervals = intervals[0];
        solution.add(tempIntervals);
        for (int[] ints : intervals) {
            if (ints[0] <= tempIntervals[1]) {
                tempIntervals[1] = Math.max(ints[1], tempIntervals[1]);
            } else {
                tempIntervals = ints;
                solution.add(tempIntervals);
            }
        }

        return solution.toArray(new int[solution.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(merge(intervals));
    }
}
