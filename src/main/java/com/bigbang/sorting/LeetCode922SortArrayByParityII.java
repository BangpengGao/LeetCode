package com.bigbang.sorting;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/22
 * @since 1.0.0
 */
public class LeetCode922SortArrayByParityII {
    /**
     * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
     * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
     * Return any answer array that satisfies this condition.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: nums = [4,2,5,7]
     * Output: [4,5,2,7]
     * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
     * <p>
     * Example 2:
     * Input: nums = [2,3]
     * Output: [2,3]
     * <p>
     * <p>
     * Constraints:
     * 2 <= nums.length <= 2 * 104
     * nums.length is even.
     * Half of the integers in nums are even.
     * 0 <= nums[i] <= 1000
     * <p>
     * <p>
     * Follow Up: Could you solve it in-place?
     *
     * @param nums
     * @return
     */
    public static int[] sortArrayByParityII(int[] nums) {
        //Runtime: 5 ms, faster than 26.67% of Java online submissions for Sort Array By Parity II.
        //Memory Usage: 43.2 MB, less than 37.32% of Java online submissions for Sort Array By Parity II.

        Deque<Integer> odd = new LinkedList<>(), even = new LinkedList<>();
        int oddIdx = Integer.MIN_VALUE, evenIdx = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0 && nums[i] % 2 != 0) {
                odd.add(nums[i]);
                if (evenIdx == Integer.MIN_VALUE) evenIdx = i;
            } else if (i % 2 != 0 && nums[i] % 2 == 0) {
                even.add(nums[i]);
                if (oddIdx == Integer.MIN_VALUE) oddIdx = i;
            }
        }
        while (odd.size() > 0 && oddIdx < nums.length) {
            if (nums[oddIdx] % 2 != 0) {
                oddIdx += 2;
                continue;
            }
            nums[oddIdx] = odd.pop();
            oddIdx += 2;
        }

        while (even.size() > 0 && evenIdx < nums.length) {
            if (nums[evenIdx] % 2 == 0) {
                evenIdx += 2;
                continue;
            }
            nums[evenIdx] = even.pop();
            evenIdx += 2;
        }
        return nums;
    }

    public static int[] sortArrayByParityIIV2(int[] nums) {
        //官方solution
        //Runtime: 2 ms, faster than 99.57% of Java online submissions for Sort Array By Parity II.
        //Memory Usage: 40.4 MB, less than 64.57% of Java online submissions for Sort Array By Parity II.

        int j = 1;
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1)
                    j += 2;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 4, 0, 2, 1, 3, 1, 3, 4};
        System.out.println(Arrays.toString(sortArrayByParityIIV2(nums)));
    }
}
