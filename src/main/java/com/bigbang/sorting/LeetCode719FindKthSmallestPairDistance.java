package com.bigbang.sorting;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/10
 * @since 1.0.0
 */
public class LeetCode719FindKthSmallestPairDistance {
    /**
     * The distance of a pair of integers a and b is defined as the absolute difference between a and b.
     * <p>
     * Given an integer array nums and an integer k,
     * return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,3,1], k = 1
     * Output: 0
     * Explanation: Here are all the pairs:
     * (1,3) -> 2
     * (1,1) -> 0
     * (3,1) -> 2
     * Then the 1st smallest distance pair is (1,1), and its distance is 0.
     * Example 2:
     * <p>
     * Input: nums = [1,1,1], k = 2
     * Output: 0
     * Example 3:
     * <p>
     * Input: nums = [1,6,1], k = 3
     * Output: 5
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == nums.length
     * 2 <= n <= 104
     * 0 <= nums[i] <= 106
     * 1 <= k <= n * (n - 1) / 2
     *
     * @param nums
     * @param k
     * @return
     */
    public static int smallestDistancePair(int[] nums, int k) {
        //活用二分查找
        //Runtime: 8 ms, faster than 28.50% of Java online submissions for Find K-th Smallest Pair Distance.
        //Memory Usage: 41.8 MB, less than 15.64% of Java online submissions for Find K-th Smallest Pair Distance.
        Arrays.sort(nums);
        int len = nums.length, low = 0, hi = nums[len - 1] - nums[0];
        while (low < hi) {
            int mid = low + (hi - low) / 2, count = 0, j = 0;
            for (int i = 0; i < len; ++i) {
                while (j < len && nums[j] - nums[i] <= mid) ++j;
                count += j - i - 1;
            }
            if (count >= k)
                hi = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {9, 10, 7, 10, 6, 1, 5, 4, 9, 8};
        System.out.println(smallestDistancePair(nums, 18));
    }
}
