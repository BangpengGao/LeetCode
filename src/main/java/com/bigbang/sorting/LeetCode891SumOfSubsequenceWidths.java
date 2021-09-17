package com.bigbang.sorting;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/17
 * @since 1.0.0
 */
public class LeetCode891SumOfSubsequenceWidths {
    /**
     * The width of a sequence is the difference between the maximum and minimum elements in the sequence.
     * Given an array of integers nums, return the sum of the widths of all the non-empty subsequences of nums.
     * Since the answer may be very large, return it modulo 109 + 7.
     * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
     * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: nums = [2,1,3]
     * Output: 6
     * Explanation: The subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
     * The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
     * The sum of these widths is 6.
     * <p>
     * Example 2:
     * Input: nums = [2]
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     *
     * @param nums
     * @return
     */
    public static int sumSubsequenceWidths(int[] nums) {
        //说白了，就是找规律问题
        //Runtime: 56 ms, faster than 25.25% of Java online submissions for Sum of Subsequence Widths.
        //Memory Usage: 79 MB, less than 10.10% of Java online submissions for Sum of Subsequence Widths.
        int MOD = 1_000_000_007;
        int N = nums.length;
        Arrays.sort(nums);

        long[] pow2 = new long[N];
        pow2[0] = 1;
        for (int i = 1; i < N; ++i)
            pow2[i] = pow2[i - 1] * 2 % MOD;

        long ans = 0;
        for (int i = 0; i < N; ++i)
            ans = (ans + (pow2[i] - pow2[N - 1 - i]) * nums[i]) % MOD;

        return (int) ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        System.out.println(sumSubsequenceWidths(nums));
    }
}
