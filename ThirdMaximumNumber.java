package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/9/17
 */

public class ThirdMaximumNumber {
    /**
     * 414. Third Maximum Number
     * Easy
     * <p>
     * Given a non-empty array of integers, return the third maximum number in this array.
     * If it does not exist, return the maximum number. The time complexity must be in O(n).
     * <p>
     * Example 1:
     * Input: [3, 2, 1]
     * Output: 1
     * Explanation: The third maximum is 1.
     * <p>
     * Example 2:
     * Input: [1, 2]
     * Output: 2
     * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     * <p>
     * Example 3:
     * Input: [2, 2, 3, 1]
     * Output: 1
     * Explanation: Note that the third maximum here means the third maximum distinct number.
     * Both numbers with value 2 are both considered as second maximum.
     */

    // 需要特别注意，nums中可能包含最小的int值
    // 所以，需要将暂存数据声明为Integer的null

    public static int solution(int[] nums) {
        int nLen = nums.length;
        if (nLen == 1)
            return nums[0];
        if (nLen == 2)
            return Math.max(nums[0], nums[1]);
        Integer rx = null, rm = null, rn = null;
        for (int i = 0; i < nLen; i++) {
            if (rx == null) {
                rx = nums[i];
                continue;
            }
            if (nums[i] > rx) {
                rn = rm;
                rm = rx;
                rx = nums[i];
            } else if (nums[i] < rx && rm == null) {
                rm = nums[i];
            } else if (nums[i] < rx && rm != null && nums[i] > rm) {
                rn = rm;
                rm = nums[i];
            } else if (rm != null && nums[i] < rm && (rn == null || nums[i] > rn)) {
                rn = nums[i];
            }
        }
        return rn == null ? rx : rn;
    }

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{2, 2, 3, 1}));
//        System.out.println(solution(new int[]{2, 1}));
//        System.out.println(solution(new int[]{3, 2, 1}));
        System.out.println(solution(new int[]{1, 2, -2147483648}));
    }
}
