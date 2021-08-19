package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/9/17
 */

public class FindTheDuplicateNumber {
    /**
     * 287. Find the Duplicate Number
     * Medium
     * <p>
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
     * prove that at least one duplicate number must exist. Assume that there is only one duplicate
     * number, find the duplicate one.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,3,4,2,2]
     * Output: 2
     * Example 2:
     * <p>
     * Input: [3,1,3,4,2]
     * Output: 3
     * Note:
     * <p>
     * You must not modify the array (assume the array is read only).
     * You must use only constant, O(1) extra space.
     * Your runtime complexity should be less than O(n2).
     * There is only one duplicate number in the array, but it could be repeated more than once.
     */

    // 解决方案1：暴力
    // Runtime: 124 ms, faster than 5.00% of Java online submissions for Find the Duplicate Number.
    // Memory Usage: 38.3 MB, less than 37.29% of Java online submissions for Find the Duplicate Number.
    public static int solution1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    res = nums[i];
                    break;
                }
            }
        }
        return res;
    }


    // 解决方案2：链表闭环判断（Floyd's Tortoise and Hare）
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Duplicate Number.
    // Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Find the Duplicate Number.
    public static int solution2(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}
