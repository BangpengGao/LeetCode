package com.bigbang.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/9/3
 * @ Time 15:33
 */
public class LeetCode532KdiffPairsInAnArray {
    /**
     * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
     * <p>
     * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
     * <p>
     * 0 <= i < j < nums.length
     * |nums[i] - nums[j]| == k
     * Notice that |val| denotes the absolute value of val.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,1,4,1,5], k = 2
     * Output: 2
     * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
     * Although we have two 1s in the input, we should only return the number of unique pairs.
     * Example 2:
     * <p>
     * Input: nums = [1,2,3,4,5], k = 1
     * Output: 4
     * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
     * Example 3:
     * <p>
     * Input: nums = [1,3,1,5,4], k = 0
     * Output: 1
     * Explanation: There is one 0-diff pair in the array, (1, 1).
     * Example 4:
     * <p>
     * Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
     * Output: 2
     * Example 5:
     * <p>
     * Input: nums = [-1,-2,-3], k = 1
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 104
     * -107 <= nums[i] <= 107
     * 0 <= k <= 107
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs(int[] nums, int k) {
        //Runtime: 428 ms, faster than 5.02% of Java online submissions for K-diff Pairs in an Array.
        //Memory Usage: 44.9 MB, less than 12.88% of Java online submissions for K-diff Pairs in an Array.

        int solution = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = nums.length - 1; j > i; j--) {
                if (Math.abs(nums[j] - nums[i]) == k) {
                    System.out.println(nums[j] + "-" + nums[i]);
                    solution++;
                    break;
                }
            }
        }
        return solution;
    }

    public static int findPairsV2(int[] nums, int k) {
        //Runtime: 20 ms, faster than 17.27% of Java online submissions for K-diff Pairs in an Array.
        //Memory Usage: 43.8 MB, less than 14.27% of Java online submissions for K-diff Pairs in an Array.

        int solution = 0;
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int n : nums)
            integerMap.put(n, integerMap.getOrDefault(n, 0) + 1);

        for (int key : integerMap.keySet()) {
            if (integerMap.containsKey(key + k)) {
                if (k != 0 || (k == 0 && integerMap.get(key) > 1))
                    solution++;
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4, 3, 3, 0, 9, 2, 3};
        int k = 3;
        System.out.println(findPairs(nums, k));
        int[] nums1 = {6, 2, 9, 3, 9, 6, 7, 7, 6, 4};
        int k1 = 3;
        System.out.println(findPairsV2(nums1, k1));
    }
}
