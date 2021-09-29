package com.bigbang.array;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/29
 * @since 1.0.0
 */
public class LeetCode34FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     * If target is not found in the array, return [-1, -1].
     * You must write an algorithm with O(log n) runtime complexity.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * <p>
     * Example 2:
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * <p>
     * Example 3:
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     * <p>
     * Constraints:
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums is a non-decreasing array.
     * -109 <= target <= 109
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
        //Memory Usage: 42.1 MB, less than 82.30% of Java online submissions for Find First and Last Position of Element in Sorted Array.

        int[] solution = {-1, -1};
        if (nums.length < 1) return solution;
        int low = 0, hi = nums.length - 1;
        while (low < hi) {
            int mid = (low + hi) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else
                hi = mid;
        }
        if (nums[low] != target) return solution;
        else
            solution[0] = low;

        hi = nums.length - 1;
        while (low < hi) {
            int mid = (low + hi) / 2 + 1;
            if (nums[mid] > target)
                hi = mid - 1;
            else
                low = mid;
        }
        solution[1] = hi;
        return solution;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        System.out.println(Arrays.toString(searchRange(nums, 2)));
    }
}
