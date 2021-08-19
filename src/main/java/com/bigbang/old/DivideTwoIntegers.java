package com.leetcode.learn;
/*
 * @ Created with IntelliJ IDEA
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/12/24
 * @ Time 16:23
 */

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        boolean flag = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            flag = true;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend == 0 || dividend < divisor)
            return 0;

        int w = 0;
        while (divisor > 1) {
            divisor = divisor >> 1;
            w += 1;
        }
        if (w == 0) return dividend;
        int res = 0;
        while (dividend > 1) {
            dividend >>= w;
            res += 1;
        }
        return flag ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(divide(7, -3));
    }
}
