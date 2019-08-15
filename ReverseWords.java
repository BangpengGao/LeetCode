package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/7/29
 */

import java.util.Arrays;

public class ReverseWords {
    /**
     * 557. Reverse Words in a String III
     * Easy
     * <p>
     * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
     * <p>
     * Example 1:
     * Input: "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
     */
    public String reverseWords(String s) {
        String[] sb = s.split(" ");
        String res = "";
        for (String s1 : sb) {
            res += new StringBuffer(s1).reverse().toString() + " ";
        }
        return res.substring(0, res.length() - 1);
    }

    public String reverseWords2(String s) {
        char[] sarr = s.toCharArray();
        for (int i = 0; i < sarr.length; ) {
            if (sarr[i] != ' '){
                int j = i;
                while (j+1<sarr.length && sarr[j+1]!=' ') j++;
                swap(sarr, i, j);
                i = j;
            }else{
                i++;
            }
        }
        return new String(sarr);
    }
    private void swap(char[] arr, int i, int j){
        for (; i < j; i++, j--) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}