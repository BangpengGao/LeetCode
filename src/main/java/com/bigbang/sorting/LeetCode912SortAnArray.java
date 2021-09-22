package com.bigbang.sorting;

import com.bigbang.sorting.algorithm.QuickSort;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/22
 * @since 1.0.0
 */
public class LeetCode912SortAnArray {
    /**
     * Given an array of integers nums, sort the array in ascending order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: nums = [5,2,3,1]
     * Output: [1,2,3,5]
     * <p>
     * Example 2:
     * Input: nums = [5,1,1,2,0,0]
     * Output: [0,0,1,1,2,5]
     * <p>
     * <p>
     * Constraints:
     * 1 <= nums.length <= 5 * 104
     * -5 * 104 <= nums[i] <= 5 * 104
     *
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {
        //Runtime: 5 ms, faster than 98.48% of Java online submissions for Sort an Array.
        //Memory Usage: 47.9 MB, less than 77.65% of Java online submissions for Sort an Array.

        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(sortArray(nums)));
    }
}
