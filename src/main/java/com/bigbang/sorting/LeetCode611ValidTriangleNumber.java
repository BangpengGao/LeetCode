package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/9/6
 * @ Time 13:24
 */
public class LeetCode611ValidTriangleNumber {
    /**
     * Given an integer array nums, return the number of triplets chosen from the array
     * that can make triangles if we take them as side lengths of a triangle.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,2,3,4]
     * Output: 3
     * Explanation: Valid combinations are:
     * 2,3,4 (using the first 2)
     * 2,3,4 (using the second 2)
     * 2,2,3
     * Example 2:
     * <p>
     * Input: nums = [4,2,3,4]
     * Output: 4
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 1000
     * 0 <= nums[i] <= 1000
     *
     * @param nums
     * @return
     */
    public static int triangleNumber(int[] nums) {
        //Runtime: 31 ms, faster than 81.48% of Java online submissions for Valid Triangle Number.
        //Memory Usage: 38.6 MB, less than 70.06% of Java online submissions for Valid Triangle Number.

        int solution = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = n - 1; i > 1; i--) {
            int l = 0, h = i - 1;
            while (l < h) {
                if (nums[l] + nums[h] > nums[i]) {
                    solution += h - l;
                    h--;
                } else l++;
            }
        }

        return solution;
    }


    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 4};
        System.out.println(triangleNumber(nums));

        int[] nums1 = {2, 2, 3, 4};
        System.out.println(triangleNumber(nums1));
    }
}
