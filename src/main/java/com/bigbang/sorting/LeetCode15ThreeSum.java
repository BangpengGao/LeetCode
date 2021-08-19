package com.bigbang.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/19
 * @ Time 10:42
 */
public class LeetCode15ThreeSum {

    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * <p>
     * Notice that the solution set must not contain duplicate triplets.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Example 2:
     * <p>
     * Input: nums = []
     * Output: []
     * Example 3:
     * <p>
     * Input: nums = [0]
     * Output: []
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     *
     * @param nums integer array nums
     * @return solution
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // Runtime: 16 ms, faster than 97.51% of Java online submissions for 3Sum.
        // Memory Usage: 42.7 MB, less than 83.05% of Java online submissions for 3Sum.

        List<List<Integer>> solution = new LinkedList<>();
        if (nums.length < 3) return solution;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int li = i + 1, hi = nums.length - 1, sum = -nums[i];
                while (li < hi) {
                    if (nums[li] + nums[hi] == sum) {
                        solution.add(Arrays.asList(nums[i], nums[li], nums[hi]));
                        while (li < hi && nums[li] == nums[li + 1]) li++;
                        while (li < hi && nums[hi] == nums[hi - 1]) hi--;
                        li++;
                        hi--;
                    } else if (nums[li] + nums[hi] < sum) li++;
                    else hi--;
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println("start");
        System.out.println(threeSum(nums));
        System.out.println("end");
    }
}
