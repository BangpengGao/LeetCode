package com.leetcode.learn;
/*
 * @ Created with IntelliJ IDEA
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/11/20
 * @ Time 17:50
 */

public class String2IntegerAtoi {
    public int myAtoi(String str) {
        String[] strings = str.split(" ");
        for (String s:strings) {
            if (!s.equals(""))
                return this.atoi(s);
        }
        return 0;
    }

    private int atoi(String s){
        if (s.length() == 0||(s.length()>=2&&((s.charAt(1)==43&&s.charAt(0)==43)||(s.charAt(1)==45&&s.charAt(0)==45)||(s.charAt(1)==43&&s.charAt(0)==45)||(s.charAt(0)==43&&s.charAt(1)==45))))
            return 0;
        char cf = s.charAt(0);
        if (cf!=43&&cf!=45&&!(cf>=48&&cf<58))
            return 0;
        StringBuilder res = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c==43&&res.length()==0)
                continue;
            if((c==45&&res.length()==0)||(c>=48&&c<58))
                res.append(c);
            else
                break;
        }
        if (res.length()==0||(res.length()==1&&res.charAt(0)==45))
            return 0;
        if (Double.parseDouble(res.toString())<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (Double.parseDouble(res.toString())>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return Integer.parseInt(res.toString());
    }

    public static void main(String[] args) {
        String2IntegerAtoi string2IntegerAtoi = new String2IntegerAtoi();
        System.out.println(string2IntegerAtoi.myAtoi("   -42"));
    }
}
