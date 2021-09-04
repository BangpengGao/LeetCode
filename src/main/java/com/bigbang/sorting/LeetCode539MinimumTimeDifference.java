package com.bigbang.sorting;

import java.text.ParseException;
import java.util.*;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/9/4
 * @ Time 10:04
 */
public class LeetCode539MinimumTimeDifference {
    /**
     * Given a list of 24-hour clock time points in "HH:MM" format,
     * return the minimum minutes difference between any two time-points in the list.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: timePoints = ["23:59","00:00"]
     * Output: 1
     * Example 2:
     * <p>
     * Input: timePoints = ["00:00","23:59","00:00"]
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 2 <= timePoints <= 2 * 104
     * timePoints[i] is in the format "HH:MM".
     *
     * @param timePoints
     * @return
     */
    public static int findMinDifference(List<String> timePoints) throws ParseException {
        //Runtime: 102 ms, faster than 5.46% of Java online submissions for Minimum Time Difference.
        //Memory Usage: 69.7 MB, less than 5.29% of Java online submissions for Minimum Time Difference.

        Set<String> timeSet = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer o1h = Integer.valueOf(o1.substring(0, 2));
                Integer o2h = Integer.valueOf(o2.substring(0, 2));
                Integer o1m = Integer.valueOf(o1.substring(3));
                Integer o2m = Integer.valueOf(o2.substring(3));
                return o1h.equals(o2h) ? Integer.compare(o1m, o2m) : Integer.compare(o1h, o2h);
            }
        });
        timeSet.addAll(timePoints);
        // 有重复值，则可得差值最小为0
        if (timeSet.size() < timePoints.size())
            return 0;

        int diff = Integer.MAX_VALUE;
        String[] strings = timeSet.toArray(new String[0]);
        for (int i = 1; i < strings.length; i++) {
            Integer o1h = Integer.valueOf(strings[i - 1].substring(0, 2));
            Integer o2h = Integer.valueOf(strings[i].substring(0, 2));
            Integer o1m = Integer.valueOf(strings[i - 1].substring(3));
            Integer o2m = Integer.valueOf(strings[i].substring(3));
            int tempDiff = (o2h - o1h) * 60 + o2m - o1m;
            diff = Math.min(diff, tempDiff);

            if (i == strings.length - 1) {
                Integer o1h0 = Integer.valueOf(strings[i].substring(0, 2));
                Integer o2h0 = Integer.valueOf(strings[0].substring(0, 2));
                Integer o1m0 = Integer.valueOf(strings[i].substring(3));
                Integer o2m0 = Integer.valueOf(strings[0].substring(3));
                int tempDiff0 = (o2h0 - o1h0 + 24) * 60 + o2m0 - o1m0;
                diff = Math.min(diff, tempDiff0);
            }
        }

        return diff == Integer.MAX_VALUE ? 0 : diff;
    }

    public static void main(String[] args) throws ParseException {
        List<String> strings = new ArrayList<>();
        strings.add("23:59");
        strings.add("00:00");
        System.out.println(findMinDifference(strings));
    }
}
