package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/15
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class RussianDollEnvelopes {
    /**
     * 354. Russian Doll Envelopes
     * Hard
     * <p>
     * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
     * What is the maximum number of envelopes can you Russian doll? (put one inside other)
     * Note:
     * Rotation is not allowed.
     * Example:
     * Input: [[5,4],[6,4],[6,7],[2,3]]
     * Output: 3
     * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
     *
     * @param envelopes
     * @return
     */
    public int solution(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));
        int n = envelopes.length;
        int[] dp = new int[n];

        int ret = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0]
                        && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public int getCurrentTime(String format) throws ParseException {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date date =sdf.parse(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public static void main(String[] arg) throws ParseException {
        RussianDollEnvelopes r = new RussianDollEnvelopes();
        int[][] a = {{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}};
        System.out.println(r.getCurrentTime("2019-08-21"));
    }
}
