package com.bigbang.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/26
 * @ Time 11:18
 */
public class LeetCode368LargestDivisibleSubset {
    /**
     * Given a set of distinct positive integers nums,
     * return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
     * <p>
     * answer[i] % answer[j] == 0, or
     * answer[j] % answer[i] == 0
     * If there are multiple solutions, return any of them.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3]
     * Output: [1,2]
     * Explanation: [1,3] is also accepted.
     * Example 2:
     * <p>
     * Input: nums = [1,2,4,8]
     * Output: [1,2,4,8]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 1000
     * 1 <= nums[i] <= 2 * 109
     * All the integers in nums are unique.
     *
     * @param nums
     * @return
     */
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        //Runtime: 31 ms, faster than 12.23% of Java online submissions for Largest Divisible Subset.
        //Memory Usage: 40.5 MB, less than 7.67% of Java online submissions for Largest Divisible Subset.
        
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8};
        System.out.println(largestDivisibleSubset(nums));
    }
}
