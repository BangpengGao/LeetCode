package com.bigbang.old;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/9/3
 */

public class ReconstructOriginalDigitsFromEnglish {
    /**
     * 423. Reconstruct Original Digits from English
     * Medium
     * <p>
     * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
     * <p>
     * Note:
     * Input contains only lowercase English letters.
     * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
     * Input length is less than 50,000.
     * Example 1:
     * Input: "owoztneoer"
     * <p>
     * Output: "012"
     * Example 2:
     * Input: "fviefuro"
     * <p>
     * Output: "45"
     */

    // 解题思路：
    // 将每一个数字独有字母的数量抠出来
    // 没有独有字母的数字，需要减去有独有字母数字的数量

    public static String solution(String s) {
        if (s == null || s.length() == 0) return "";
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i)]++;
        int[] num = new int[10];
        num[0] = count['z'];
        num[2] = count['w'];
        num[4] = count['u'];
        num[6] = count['x'];
        num[8] = count['g'];
        num[1] = count['o'] - count['z'] - count['w'] - count['u'];
        num[3] = count['h'] - count['g'];
        num[5] = count['v'] - count['s'] + count['x'];
        num[7] = count['s'] - count['x'];
        num[9] = count['i'] - count['x'] - count['g'] - count['v'] + count['s'] - count['x'];
        String ret = new String();
        for (int i = 0; i < 10; i++)
            for (int j = num[i]; j > 0; j--) ret += String.valueOf(i);
        return ret;
    }
}
