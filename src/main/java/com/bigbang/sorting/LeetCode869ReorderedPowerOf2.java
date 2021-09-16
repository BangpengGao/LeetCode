package com.bigbang.sorting;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/16
 * @since 1.0.0
 */
public class LeetCode869ReorderedPowerOf2 {
    /**
     * You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
     * <p>
     * Return true if and only if we can do this so that the resulting number is a power of two.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 1
     * Output: true
     * Example 2:
     * <p>
     * Input: n = 10
     * Output: false
     * Example 3:
     * <p>
     * Input: n = 16
     * Output: true
     * Example 4:
     * <p>
     * Input: n = 24
     * Output: false
     * Example 5:
     * <p>
     * Input: n = 46
     * Output: true
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 109
     *
     * @param n
     * @return
     */
    public static boolean reorderedPowerOf2(int n) {
        //Runtime: 1 ms, faster than 95.24% of Java online submissions for Reordered Power of 2.
        //Memory Usage: 38.2 MB, less than 16.67% of Java online submissions for Reordered Power of 2.
        
        int[] N = count(n);
        for (int i = 0; i < 31; ++i) {
            if (Arrays.equals(N, count(1 << i)))
                return true;
        }
        return false;
    }

    public static int[] count(int N) {
        int[] ans = new int[10];
        while (N > 0) {
            ans[N % 10]++;
            N /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(10));
    }
}
