package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/21
 * @ Time 9:58
 */
public class LeetCode179LargestNumber {

    /**
     * Given a list of non-negative integers nums, arrange them such that they form the largest number.
     * <p>
     * Note: The result may be very large, so you need to return a string instead of an integer.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [10,2]
     * Output: "210"
     * Example 2:
     * <p>
     * Input: nums = [3,30,34,5,9]
     * Output: "9534330"
     * Example 3:
     * <p>
     * Input: nums = [1]
     * Output: "1"
     * Example 4:
     * <p>
     * Input: nums = [10]
     * Output: "10"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 109
     *
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        //Runtime: 4 ms, faster than 98.26% of Java online submissions for Largest Number.
        //Memory Usage: 38.3 MB, less than 76.37% of Java online submissions for Largest Number.

        if (nums == null || nums.length < 1) return "";
        String[] stringList = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            stringList[i] = String.valueOf(nums[i]);

        Arrays.sort(stringList, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (stringList[0].equals("0")) return "0";
        StringBuilder solution = new StringBuilder();
        for (String s : stringList)
            solution.append(s);
        return solution.toString();
    }

    public static void main(String[] args) {
        int[] nums = {10,2};
        System.out.println(largestNumber(nums));
    }
}
