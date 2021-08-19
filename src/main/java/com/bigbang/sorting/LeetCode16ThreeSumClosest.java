package com.bigbang.sorting;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/19
 * @ Time 11:10
 */

import java.util.Arrays;

public class LeetCode16ThreeSumClosest {
    /**
     * Given an integer array nums of length n and an integer target,
     * find three integers in nums such that the sum is closest to target.
     * <p>
     * Return the sum of the three integers.
     * <p>
     * You may assume that each input would have exactly one solution.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [-1,2,1,-4], target = 1
     * Output: 2
     * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * Example 2:
     * <p>
     * Input: nums = [0,0,0], target = 1
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 3 <= nums.length <= 1000
     * -1000 <= nums[i] <= 1000
     * -104 <= target <= 104
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        //Runtime: 6 ms, faster than 47.12% of Java online submissions for 3Sum Closest.
        //Memory Usage: 38.8 MB, less than 30.49% of Java online submissions for 3Sum Closest.

        int solution = nums[0] + nums[1] + nums[2], diff = Math.abs(target - solution), length = nums.length;
        if (length == 3) return solution;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            int li = i + 1, hi = length - 1;
            while (li < hi) {
                int sum = nums[i] + nums[li] + nums[hi], diff1 = sum - target;
                if (Math.abs(diff1) < diff) {
                    solution = sum;
                    diff = Math.abs(diff1);
                }
                if (diff1 < 0) li++;
                else hi--;
            }
        }

        return solution;
    }

    /**
     * 更新修改后的解决方案，运行时间更短
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosestModified1(int[] nums, int target) {
        //Runtime: 4 ms, faster than 83.83% of Java online submissions for 3Sum Closest.
        //Memory Usage: 38.8 MB, less than 43.12% of Java online submissions for 3Sum Closest.

        int solution = nums[0] + nums[1] + nums[2], length = nums.length, sum = solution;
        if (length == 3) return solution;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            int li = i + 1, hi = length - 1;
            while (li < hi) {
                sum = nums[i] + nums[li] + nums[hi];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    while (li < hi && nums[li] == nums[li + 1])
                        li++;
                    li++;
                } else {
                    while (li < hi && nums[hi] == nums[hi - 1])
                        hi--;
                    hi--;
                }
                if (Math.abs(target - solution) > Math.abs(target - sum)) solution = sum;
            }
        }

        return solution;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println("start");
        System.out.println(threeSumClosest(nums, 1));
        System.out.println("end");

        int[] nums2 = {0, 0, 0};
        System.out.println("start");
        System.out.println(threeSumClosest(nums2, 1));
        System.out.println("end");
    }
}
