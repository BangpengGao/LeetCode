package com.bigbang.sorting;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/23
 * @ Time 14:08
 */
public class LeetCode217ContainsDuplicate {
    /**
     * Given an integer array nums, return true if any value appears at least twice in the array,
     * and return false if every element is distinct.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,1]
     * Output: true
     * Example 2:
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: false
     * Example 3:
     * <p>
     * Input: nums = [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        //Runtime: 6 ms, faster than 53.95% of Java online submissions for Contains Duplicate.
        //Memory Usage: 47.1 MB, less than 12.18% of Java online submissions for Contains Duplicate.

        Set<Integer> integerSet = new LinkedHashSet<>();
        for (int n : nums)
            integerSet.add(n);
        return integerSet.size() == nums.length;
    }

    public static boolean containsDuplicateV2(int[] nums) {
        //Runtime: 7 ms, faster than 18.46% of Java online submissions for Contains Duplicate.
        //Memory Usage: 46.2 MB, less than 17.36% of Java online submissions for Contains Duplicate.

        return Arrays.stream(nums).distinct().count() != nums.length;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));

        System.out.println(1>>3);
    }
}
