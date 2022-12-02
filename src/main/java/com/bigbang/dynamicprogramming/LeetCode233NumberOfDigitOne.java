package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/29
 * @since 1.0.0
 */
public class LeetCode233NumberOfDigitOne {
    /**
     * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: n = 13
     * Output: 6
     * <p>
     * Example 2:
     * Input: n = 0
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * 0 <= n <= 109
     *
     * @param n
     * @return
     */
    public static int countDigitOne(int n) {
        //from low to high
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Digit One.
        //Memory Usage: 36.1 MB, less than 53.03% of Java online submissions for Number of Digit One.
        int memory = 0, residue = 0, base = 1, count = 0;
        while (n > 0) {
            int t = n % 10;
            if (t > 1) count += t * memory + base;
            else if (t == 1) count += memory + residue + 1;
            residue += t * base;
            n /= 10;
            memory = 10 * memory + base;
            base *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }
}
