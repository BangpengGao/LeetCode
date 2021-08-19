package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/9/10
 */

public class Convert2BaseNeg2 {
    /**
     * 1017. Convert to Base -2
     * Medium
     * <p>
     * Given a number N, return a string consisting of "0"s and "1"s that represents its value
     * in base -2 (negative two).
     * <p>
     * The returned string must have no leading zeroes, unless the string is "0".
     * <p>
     * Example 1:
     * <p>
     * Input: 2
     * Output: "110"
     * Explantion: (-2) ^ 2 + (-2) ^ 1 = 2
     * Example 2:
     * <p>
     * Input: 3
     * Output: "111"
     * Explantion: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
     * Example 3:
     * <p>
     * Input: 4
     * Output: "100"
     * Explantion: (-2) ^ 2 = 4
     * <p>
     * Note:
     * <p>
     * 0 <= N <= 10^9
     */
    public static String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            sb.append(N & 1);
            N = -(N >> 1);
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }

    public static String base2(int N) {
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            sb.append(N & 1);
            N = N >> 1;
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(baseNeg2(3));
        System.out.println(base2(3));
    }
}
