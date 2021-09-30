package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/30
 * @since 1.0.0
 */
public class LeetCode96UniqueBinarySearchTrees {
    /**
     * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: n = 3
     * Output: 5
     * <p>
     * Example 2:
     * Input: n = 1
     * Output: 1
     * <p>
     * Constraints:
     * 1 <= n <= 19
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
        //Memory Usage: 35.6 MB, less than 83.82% of Java online submissions for Unique Binary Search Trees.

        int[] nums = new int[n + 1];
        nums[0] = nums[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                nums[i] += nums[j - 1] * nums[i - j];
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
