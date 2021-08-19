package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/30
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OccurrencesAfterBigram {
    /**
     * 1078. Occurrences After Bigram
     * Easy
     * <p>
     * Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
     * <p>
     * For each such occurrence, add "third" to the answer, and return the answer.
     * <p>
     * Example 1:
     * <p>
     * Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
     * Output: ["girl","student"]
     * Example 2:
     * <p>
     * Input: text = "we will we will rock you", first = "we", second = "will"
     * Output: ["we","rock"]
     * <p>
     * Note:
     * <p>
     * 1 <= text.length <= 1000
     * text consists of space separated words, where each word consists of lowercase English letters.
     * 1 <= first.length, second.length <= 10
     * first and second consist of lowercase English letters.
     */
    public static String[] findOcurrences(String text, String first, String second) {
        String[] textArr = text.split(" ");
        List<String> res = new ArrayList<>();
        if (textArr.length < 3) {
            res.toArray(new String[res.size()]);
        }
        for (int i = 0; i < textArr.length - 2; i++) {
            if (textArr[i].equals(first) && textArr[i + 1].equals(second))
                res.add(textArr[i + 2]);
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOcurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(findOcurrences("we will we will rock you", "we", "will")));
    }
}
