package com.bigbang.array;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/29
 * @since 1.0.0
 */
public class LeetCode31NextPermutation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
     * The replacement must be in place and use only constant extra memory.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: nums = [1,2,3]
     * Output: [1,3,2]
     * <p>
     * Example 2:
     * Input: nums = [3,2,1]
     * Output: [1,2,3]
     * <p>
     * Example 3:
     * Input: nums = [1,1,5]
     * Output: [1,5,1]
     * <p>
     * Example 4:
     * Input: nums = [1]
     * Output: [1]
     * <p>
     * <p>
     * Constraints:
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
        //Memory Usage: 39 MB, less than 76.10% of Java online submissions for Next Permutation.

        int len = nums.length - 2;
        while (len >= 0 && nums[len] >= nums[len + 1]) {
            len--;
        }
        if (len >= 0) {
            int len1 = nums.length - 1;
            while (nums[len1] <= nums[len]) {
                len1--;
            }
            swap(nums, len, len1);
        }
        reverse(nums, len + 1);
    }

    public static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
