package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/5
 */

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.HashMap;
import java.util.Map;

public class JewelsandStones {
    /**
     * 771. Jewels and Stones
     * Easy
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
     * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
     * Example 1:
     * Input: J = "aA", S = "aAAbbbb"
     * Output: 3
     * Example 2:
     * Input: J = "z", S = "ZZ"
     * Output: 0
     * Note:
     * S and J will consist of letters and have length at most 50.
     * The characters in J are distinct.
     */
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        if (J.length()==0 || S.length()==0)
            return res;
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i=0; i<S.length();i++){
            if (sMap.containsKey(S.charAt(i))){
                int sValue = sMap.get(S.charAt(i));
                sMap.put(S.charAt(i), sValue+1);
            }else {
                sMap.put(S.charAt(i), 1);
            }
        }
        char[] jArr = J.toCharArray();
        for (Character c : jArr){
            if (sMap.containsKey(c)){
                res += sMap.get(c);
            }
        }
        return res;
    }
}
