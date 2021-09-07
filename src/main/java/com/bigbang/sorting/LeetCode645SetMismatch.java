package com.bigbang.sorting;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/7
 * @since 1.0.0
 */
public class LeetCode645SetMismatch {
    /**
     * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately,
     * due to some error, one of the numbers in s got duplicated to another number in the set,
     * which results in repetition of one number and loss of another number.
     * <p>
     * You are given an integer array nums representing the data status of this set after the error.
     * <p>
     * Find the number that occurs twice and the number that is missing and return them in the form of an array.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,2,4]
     * Output: [2,3]
     * Example 2:
     * <p>
     * Input: nums = [1,1]
     * Output: [1,2]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 2 <= nums.length <= 104
     * 1 <= nums[i] <= 104
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {
        //Runtime: 1 ms, faster than 100.00% of Java online submissions for Set Mismatch.
        //Memory Usage: 40.8 MB, less than 49.35% of Java online submissions for Set Mismatch.

        int[] temp = new int[nums.length];
        for (int num : nums) {
            temp[num - 1]++;
        }
        int[] solution = new int[2];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 2)
                solution[0] = i + 1;
            else if (temp[i] == 0)
                solution[1] = i + 1;
        }
        return solution;
    }

    public static int[] findErrorNumsV2(int[] nums) {
        // 这种方式占用内存更少

        int[] solution = new int[2];
        for (int n : nums) {
            if (nums[Math.abs(n) - 1] < 0) solution[0] = n;
            else nums[Math.abs(n) - 1] *= -1;
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0) solution[1] = i + 1;

        return solution;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(nums)));

        System.out.println(Arrays.toString(findErrorNumsV2(nums)));
    }
}
