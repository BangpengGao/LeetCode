package com.bigbang.old.learn;
/*
 * @ Created with IntelliJ IDEA
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/12/19
 * @ Time 15:44
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;
        int xc = x;
        List<Integer> integerList = new ArrayList<>();
        while (xc != 0) {
            integerList.add(xc % 10);
            xc /= 10;
        }
        int len = integerList.size();
        for (int i = 0; i < len / 2; i++) {
            if (!integerList.get(i).equals(integerList.get(len - i - 1)))
                return false;
        }
        return true;
    }

    public boolean solution2(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;
        String str = String.valueOf(x);
        int len = str.length();
        for (int i = 0; i < len / 2; i++)
            if (str.charAt(i) == str.charAt(len - i - 1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.solution2(1001));
    }
}
