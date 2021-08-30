package com.bigbang.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/30
 * @ Time 14:39
 */
public class LeetCode436FindRightInterval {
    /**
     * You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
     * The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
     * Return an array of right interval indices for each interval i.
     * If no right interval exists for interval i, then put -1 at index i.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: intervals = [[1,2]]
     * Output: [-1]
     * Explanation: There is only one interval in the collection, so it outputs -1.
     * <p>
     * Example 2:
     * Input: intervals = [[3,4],[2,3],[1,2]]
     * Output: [-1,0,1]
     * Explanation: There is no right interval for [3,4].
     * The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
     * The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
     * <p>
     * Example 3:
     * Input: intervals = [[1,4],[2,3],[3,4]]
     * Output: [-1,2,-1]
     * Explanation: There is no right interval for [1,4] and [3,4].
     * The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
     * <p>
     * <p>
     * Constraints:
     * 1 <= intervals.length <= 2 * 104
     * intervals[i].length == 2
     * -106 <= starti <= endi <= 106
     * The start point of each interval is unique.
     *
     * @param intervals
     * @return
     */
    public static int[] findRightInterval(int[][] intervals) {
        //可以自己是自己的right interval
        //寻找最小的，使right[0]小于等于current[1]，right[1]小于等于current[0]
        //Runtime: 677 ms, faster than 5.09% of Java online submissions for Find Right Interval.
        //Memory Usage: 41.8 MB, less than 96.86% of Java online submissions for Find Right Interval.

        int[] solution = new int[intervals.length];
        Arrays.fill(solution, -1);
        if (intervals.length < 2) {
            return solution;
        }

        for (int i = 0; i < intervals.length; i++) {
            int index = Integer.MAX_VALUE;
            for (int j = 0; j < intervals.length; j++) {
                if (j == i) continue;
                if ((index == Integer.MAX_VALUE || (intervals[index][0] > intervals[j][0] &&
                        intervals[index][1] > intervals[j][1])) &&
                        intervals[j][0] >= intervals[i][1] &&
                        intervals[j][1] >= intervals[i][0]) {
                    index = j;
                }
            }
            if (index != Integer.MAX_VALUE)
                solution[i] = index;
        }
        return solution;
    }

    public static int[] findRightIntervalV2(int[][] intervals) {
        int len = intervals.length;
        int[] solution = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        int[] s = new int[len];
        for (int i = 0; i < len; i++) {
            s[i] = intervals[i][0];
            map.put(s[i], i);
        }
        Arrays.sort(s);
        for (int i = 0; i < len; i++) {
            solution[i] = binarySearch(s, map, intervals[i][1]);
        }
        return solution;
    }

    public static int binarySearch(int[] s, Map<Integer, Integer> map, int v) {
        if (v <= s[0])
            return map.get(s[0]);
        else if (v > s[s.length - 1])
            return -1;
        int l = 0, h = s.length;
        while (l < h) {
            int mid = (l + h) >>> 1;
            if (s[mid] >= v)
                h = mid;
            else
                l = mid + 1;
        }
        return map.get(s[l]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 3}, {3, 4}};
        System.out.println(Arrays.toString(findRightInterval(intervals)));

        int[][] ints = {{3, 4}, {2, 3}, {1, 2}};
        System.out.println(Arrays.toString(findRightIntervalV2(ints)));
    }
}
