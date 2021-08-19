package com.leetcode.learn;
/*
 * @ Created with IntelliJ IDEA
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/12/20
 * @ Time 16:26
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    /**
     * 17. Letter Combinations of a Phone Number
     * Medium
     * <p>
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
     * that the number could represent.
     * <p>
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that
     * 1 does not map to any letters.
     * <p>
     * Example:
     * <p>
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Note:
     * <p>
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     *
     * @param digits
     * @return
     */
    // Runtime: 1 ms, faster than 55.50% of Java online submissions for Letter Combinations of a Phone Number.
    // Memory Usage: 36.2 MB, less than 98.63% of Java online submissions for Letter Combinations of a Phone Number.

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) return res;
        combination("", digits);
        return res;
    }

    public void combination(String format, String digits) {
        if (digits.length() == 0) {
            res.add(format);
        } else {
            String digit = digits.substring(0, 1);
            String letter = phone.get(digit);
            for (int i = 0; i < letter.length(); i++) {
                String l = letter.substring(i, i + 1);
                combination(format + l, digits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
        System.out.println(l.letterCombinations("222"));
    }
}
