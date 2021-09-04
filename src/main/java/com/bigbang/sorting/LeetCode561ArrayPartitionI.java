package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/9/4
 * @ Time 11:04
 */
public class LeetCode561ArrayPartitionI {
    /**
     * Given an integer array nums of 2n integers,
     * group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized.
     * Return the maximized sum.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,4,3,2]
     * Output: 4
     * Explanation: All possible pairings (ignoring the ordering of elements) are:
     * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
     * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
     * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
     * So the maximum possible sum is 4.
     * Example 2:
     * <p>
     * Input: nums = [6,2,6,5,1,2]
     * Output: 9
     * Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 104
     * nums.length == 2 * n
     * -104 <= nums[i] <= 104
     *
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        //Runtime: 10 ms, faster than 96.79% of Java online submissions for Array Partition I.
        //Memory Usage: 41 MB, less than 76.90% of Java online submissions for Array Partition I.

        if (nums.length < 1) return 0;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; ) {
            sum += nums[i];
            i += 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }
}
