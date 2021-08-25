package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/24
 * @ Time 14:49
 */
public class LeetCode324WiggleSortII {
    /**
     * Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
     * <p>
     * You may assume the input array always has a valid answer.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,5,1,1,6,4]
     * Output: [1,6,1,5,1,4]
     * Explanation: [1,4,1,5,1,6] is also accepted.
     * Example 2:
     * <p>
     * Input: nums = [1,3,2,2,3,1]
     * Output: [2,3,1,3,1,2]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 5 * 104
     * 0 <= nums[i] <= 5000
     * It is guaranteed that there will be an answer for the given input nums.
     * <p>
     * <p>
     * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
     *
     * @param nums
     */
    public static void wiggleSort(int[] nums) {
        //Runtime: 3 ms, faster than 69.33% of Java online submissions for Wiggle Sort II.
        //Memory Usage: 41.9 MB, less than 49.85% of Java online submissions for Wiggle Sort II.

        //sort the array
        Arrays.sort(nums);

        // find mid point of array
        int mid = (nums.length - 1) / 2;
        int right = nums.length - 1;

        //aux array to temp store the values
        int[] result = new int[right + 1];
        int counter = 0;

        // select values from two parts of the array and arrange them in aux array
        while (mid >= 0 || right > (nums.length - 1) / 2) {
            if (counter % 2 == 0) {
                result[counter] = nums[mid];
                mid--;
            } else {
                result[counter] = nums[right];
                right--;
            }
            counter++;
        }

        //now store back these values in input/original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
