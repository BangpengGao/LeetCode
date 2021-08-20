package com.bigbang.old;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/9/10
 */

public class SumOfSquareNumbers {
    /**
     * 633. Sum of Square Numbers
     * Easy
     * <p>
     * Given a non-negative integer c, your task is to decide whether there're two integers
     * a and b such that a2 + b2 = c.
     * <p>
     * Example 1:
     * <p>
     * Input: 5
     * Output: True
     * Explanation: 1 * 1 + 2 * 2 = 5
     * <p>
     * Example 2:
     * <p>
     * Input: 3
     * Output: False
     */
    public static boolean solution(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
