package com.bigbang.old.learn;
/*
 * @ Created with IntelliJ IDEA
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/12/19
 * @ Time 17:15
 */

import java.util.regex.Pattern;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return Pattern.matches(p, s);
    }

    public static void main(String[] args) {
        RegularExpressionMatching r = new RegularExpressionMatching();
        System.out.println(r.isMatch("aa", "a"));
    }
}
