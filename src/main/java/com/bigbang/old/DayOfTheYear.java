package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/21
 */

import java.util.HashMap;
import java.util.Map;

public class DayOfTheYear {
    /**
     * 1154. Day of the Year
     * Easy
     *
     * 27
     *
     * 44
     *
     * Favorite
     *
     * Share
     * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
     *
     *
     *
     * Example 1:
     *
     * Input: date = "2019-01-09"
     * Output: 9
     * Explanation: Given date is the 9th day of the year in 2019.
     * Example 2:
     *
     * Input: date = "2019-02-10"
     * Output: 41
     * Example 3:
     *
     * Input: date = "2003-03-01"
     * Output: 60
     * Example 4:
     *
     * Input: date = "2004-03-01"
     * Output: 61
     *
     * Constraints:
     * date.length == 10
     * date[4] == date[7] == '-', and all other date[i]'s are digits
     * date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.
     */

    public static final Map<Integer, Integer> days = new HashMap();

    static {
        days.put(1, 31);
        days.put(2, 59);
        days.put(3, 90);
        days.put(4, 120);
        days.put(5, 151);
        days.put(6, 181);
        days.put(7, 212);
        days.put(8, 243);
        days.put(9, 273);
        days.put(10, 304);
        days.put(11, 334);
        days.put(12, 365);
    }

    public int dayOfYear(String date) {
        String[] dataArr = date.split("-");
        int year = Integer.parseInt(dataArr[0]);
        int month = Integer.parseInt(dataArr[1]);
        int day = Integer.parseInt(dataArr[2]);
        if (month == 1)
            return day;
        if (month == 2)
            return days.get(month - 1) + day;
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))? days.get(month - 1) + day + 1 : days.get(month - 1) + day;
    }

    public static void main(String[] arg){
        DayOfTheYear dayOfTheYear = new DayOfTheYear();
        System.out.println(dayOfTheYear.dayOfYear("1900-03-25"));
    }
}
