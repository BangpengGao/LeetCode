package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/27
 */

public class NumberOfSubarraysWithBoundedMaximum {
    /**
     * 795. Number of Subarrays with Bounded Maximum
     * Medium
     *
     * We are given an array A of positive integers, and two positive integers L and R (L <= R).
     *
     * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array
     * element in that subarray is at least L and at most R.
     *
     * Example :
     * Input:
     * A = [2, 1, 4, 3]
     * L = 2
     * R = 3
     * Output: 3
     * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
     * Note:
     *
     * L, R  and A[i] will be an integer in the range [0, 10^9].
     * The length of A will be in the range of [1, 50000].
     */

    /**
     * 个人解题思路：
     * 第一想法，暴力解决找出所有的子数组，然后统计满足条件的数量（有可能TEL）
     * <p>
     * 大神的解决方案：
     * ①两个flag变量j和count，j表示上一次小于等于R的索引（默认为0），如果大于R，则将j更新为当前索引+1的值，
     * count表示j到A[i]大于等于L小于等于R的长度，也可以认为是满足条件的子数组的数量。
     * ②当i向右移动，如果A[i]大于等于L小于等于R，更新count；如果小于L，自加count；否则，更新j，count归零
     */
    public int solution(int[] A, int L, int R) {
        int j = 0, count = 0, res = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= L && A[i] <= R) {
                res += i - j + 1;
                count = i - j + 1;
            } else if (A[i] < L) {
                res += count;
            } else {
                j = i + 1;
                count = 0;
            }
        }
        return res;
    }
}
