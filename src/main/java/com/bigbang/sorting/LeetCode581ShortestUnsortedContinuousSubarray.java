package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/9/4
 * @ Time 11:09
 */
public class LeetCode581ShortestUnsortedContinuousSubarray {
    /**
     * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order,
     * then the whole array will be sorted in ascending order.
     * <p>
     * Return the shortest such subarray and output its length.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,6,4,8,10,9,15]
     * Output: 5
     * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
     * Example 2:
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: 0
     * Example 3:
     * <p>
     * Input: nums = [1]
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 104
     * -105 <= nums[i] <= 105
     * <p>
     * <p>
     * Follow up: Can you solve it in O(n) time complexity?
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        //Runtime: 6 ms, faster than 42.41% of Java online submissions for Shortest Unsorted Continuous Subarray.
        //Memory Usage: 40.2 MB, less than 76.66% of Java online submissions for Shortest Unsorted Continuous Subarray.
        
        if (nums.length < 2) return 0;
        int start = 0, end = nums.length - 1;
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        while (start < nums.length) {
            if (nums[start] == temp[start])
                start++;
            else break;
        }
        if (start == nums.length - 1) return 0;
        while (end > start) {
            if (nums[end] == temp[end])
                end--;
            else break;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(findUnsortedSubarray(nums));
        int[] nums1 = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums1));
        int[] nums2 = {1, 3, 2, 2, 2};
        System.out.println(findUnsortedSubarray(nums2));
    }
}
