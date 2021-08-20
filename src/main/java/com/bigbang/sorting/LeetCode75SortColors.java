package com.bigbang.sorting;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/19
 * @ Time 16:27
 */
public class LeetCode75SortColors {
    /**
     * Given an array nums with n objects colored red, white, or blue,
     * sort them in-place so that objects of the same color are adjacent,
     * with the colors in the order red, white, and blue.
     * <p>
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     * <p>
     * You must solve this problem without using the library's sort function.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Example 2:
     * <p>
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     * Example 3:
     * <p>
     * Input: nums = [0]
     * Output: [0]
     * Example 4:
     * <p>
     * Input: nums = [1]
     * Output: [1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] is 0, 1, or 2.
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
        //Memory Usage: 37.8 MB, less than 30.51% of Java online submissions for Sort Colors.

        quickSort(nums, 0, nums.length - 1);
    }

    //手写快排
    public static void quickSort(int[] nums, int low, int high) {
        int pivot, pos, i, t;
        if (low < high) {
            pos = low;
            pivot = nums[pos];
            for (i = low + 1; i <= high; i++) {
                if (nums[i] < pivot) {
                    pos++;
                    t = nums[pos];
                    nums[pos] = nums[i];
                    nums[i] = t;
                }
            }
            t = nums[low];
            nums[low] = nums[pos];
            nums[pos] = t;

            quickSort(nums, low, pos - 1);
            quickSort(nums, pos + 1, high);
        }
    }

    // 专门针对本题，不算类型通用方法
    public static void sortColorsV2(int[] nums) {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
        //Memory Usage: 37.7 MB, less than 30.51% of Java online submissions for Sort Colors.
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[c] = i;
                c++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }
}
