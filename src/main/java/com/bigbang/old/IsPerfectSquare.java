package com.bigbang.old;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/7/25
 */

public class IsPerfectSquare {
    /**
     * 367. Valid Perfect Square
     * Easy
     * Given a positive integer num, write a function which returns True if num is a perfect square else False.
     * Note: Do not use any built-in library function such as sqrt.
     * Example 1:
     * Input: 16
     * Output: true
     * Example 2:
     * Input: 14
     * Output: false
     */
    public boolean perfectSquare(int num){
        if (num==1)
            return true;
        int mid = num/2;
        for (int i=2;i<=mid;i++){
            if (i*i==num){
                return true;
            }
        }
        return false;
    }
}
