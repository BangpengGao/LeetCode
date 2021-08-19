package com.bigbang.sorting;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/19
 * @ Time 13:43
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode18FourSum {

    /**
     * Given an array nums of n integers,
     * return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     * <p>
     * 0 <= a, b, c, d < n
     * a, b, c, and d are distinct.
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * You may return the answer in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,0,-1,0,-2,2], target = 0
     * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * Example 2:
     * <p>
     * Input: nums = [2,2,2,2,2], target = 8
     * Output: [[2,2,2,2]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //Runtime: 14 ms, faster than 68.78% of Java online submissions for 4Sum.
        //Memory Usage: 39.4 MB, less than 74.21% of Java online submissions for 4Sum.
        List<List<Integer>> solution = new LinkedList<>();
        int length = nums.length;
        if (length < 4) return solution;

        Arrays.sort(nums);
        for (int i = 0; i < length - 3; i++) {
            // 过滤掉重复项
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < length - 2; j++) {
                // 过滤掉重复项
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int li = j + 1, hi = length - 1;
                while (li < hi) {
                    if (nums[i] + nums[j] + nums[li] + nums[hi] == target) {
                        solution.add(Arrays.asList(nums[i], nums[j], nums[li], nums[hi]));
                        li++;
                        hi--;
                        while (li < hi && nums[li] == nums[li - 1]) {
                            li++;
                        }
                        while (li < hi && nums[hi] == nums[hi + 1]) {
                            hi--;
                        }
                    } else if (nums[i] + nums[j] + nums[li] + nums[hi] > target) hi--;
                    else li++;
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, 1, 1, 2, 2};
        System.out.println("start");
        System.out.println(fourSum(nums, 0));
        System.out.println("end");
    }
}
