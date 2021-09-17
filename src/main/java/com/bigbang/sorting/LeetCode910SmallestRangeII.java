package com.bigbang.sorting;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/17
 * @since 1.0.0
 */
public class LeetCode910SmallestRangeII {
    /**
     * You are given an integer array nums and an integer k.
     * <p>
     * For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.
     * <p>
     * The score of nums is the difference between the maximum and minimum elements in nums.
     * <p>
     * Return the minimum score of nums after changing the values at each index.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1], k = 0
     * Output: 0
     * Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
     * Example 2:
     * <p>
     * Input: nums = [0,10], k = 2
     * Output: 6
     * Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.
     * Example 3:
     * <p>
     * Input: nums = [1,3,6], k = 3
     * Output: 3
     * Explanation: Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6 - 3 = 3.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 104
     * 0 <= k <= 104
     *
     * @param nums
     * @param k
     * @return
     */
    public static int smallestRangeII(int[] nums, int k) {
        //Runtime: 10 ms, faster than 30.21% of Java online submissions for Smallest Range II.
        //Memory Usage: 46.4 MB, less than 26.10% of Java online submissions for Smallest Range II.

        int len = nums.length;
        Arrays.sort(nums);
        int ans = nums[len - 1] - nums[0];

        for (int i = 0; i < len - 1; ++i) {
            int a = nums[i], b = nums[i + 1];
            int max = Math.max(nums[len - 1] - k, a + k);
            int min = Math.min(nums[0] + k, b - k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 2};
        int k = 1;
        System.out.println(smallestRangeII(nums, k));
    }
}
