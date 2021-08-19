package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/14
 */

public class PerfectNumber {
    /**
     * 507. Perfect Number
     * Easy
     *
     * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
     * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
     * Example:
     * Input: 28
     * Output: True
     * Explanation: 28 = 1 + 2 + 4 + 7 + 14
     * Note: The input number n will not exceed 100,000,000. (1e8)
     * @param num
     * @return
     */
    public boolean solution(int num) {
        if (num == 0)
            return false;
        int temp = 0;
        int cNum;
        if (num % 2 == 0)
            cNum = num / 2;
        else if (num % 3 == 0)
            cNum = num / 3;
        else
            cNum = num - 1;
        for (int i = 1; i <= cNum; i++) {
            if (num % i == 0)
                temp += i;
        }
        return temp == num;
    }

    public boolean solution2(int num) {
        if (num == 1) return false;

        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        sum++;

        return sum == num;
    }

    public static void main(String[] arg) {
        PerfectNumber p = new PerfectNumber();
        System.out.println(p.solution(28));
    }
}
