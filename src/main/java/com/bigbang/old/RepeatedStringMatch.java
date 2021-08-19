package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/9/10
 */

public class RepeatedStringMatch {
    /**
     * 686. Repeated String Match
     * Easy
     * <p>
     * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring
     * of it. If no such solution, return -1.
     * <p>
     * For example, with A = "abcd" and B = "cdabcdab".
     * <p>
     * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a
     * substring of A repeated two times ("abcdabcd").
     * <p>
     * Note:
     * The length of A and B will be between 1 and 10000.
     */
    public static int solution(String A, String B) {
        int m = B.length() / A.length();
        if (B.length() % A.length() >= 1)
            m += 1;
        int s = m;
        StringBuilder sb = new StringBuilder();
        while (m > 0) {
            sb.append(A);
            m--;
        }
        if (sb.toString().contains(B))
            return s;
        if (sb.append(A).toString().contains(B))
            return s + 1;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcd", "cdabcdab"));
    }
}
