package com.bigbang.old;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/7/29
 */

public class ReverseStr {
    /**
     * 541. Reverse String II
     * Easy
     *
     * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
     * Example:
     * Input: s = "abcdefg", k = 2
     * Output: "bacdfeg"
     * Restrictions:
     * The string consists of lower English letters only.
     * Length of the given string and k will in the range [1, 10000]
     */
    public String solution(String s, int k) {
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if ((i + 1) % k == 0 && (i + 1) / k % 2 == 1) {
                sb.append(s.charAt(i));
                res.append(sb.reverse().toString());
                sb = new StringBuilder();
                flag = true;
            } else if ((i + 1) % k == 0 && (i + 1) / k % 2 == 0) {
                sb.append(s.charAt(i));
                res.append(sb.toString());
                sb = new StringBuilder();
                flag = false;
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (!flag) {
            res.append(sb.reverse().toString());
            sb = new StringBuilder();
        } else {
            res.append(sb.toString());
            sb = new StringBuilder();
        }
        return res.toString();
    }

    public String solution2(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }

    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
