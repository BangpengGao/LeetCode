package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/23
 * @ Time 13:32
 */
public class LeetCode215KthLargestElementInAnArray {
    /**
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     * <p>
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,2,1,5,6,4], k = 2
     * Output: 5
     * Example 2:
     * <p>
     * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     * Output: 4
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= k <= nums.length <= 104
     * -104 <= nums[i] <= 104
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        //Runtime: 1 ms, faster than 97.98% of Java online submissions for Kth Largest Element in an Array.
        //Memory Usage: 39.3 MB, less than 64.97% of Java online submissions for Kth Largest Element in an Array.

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
