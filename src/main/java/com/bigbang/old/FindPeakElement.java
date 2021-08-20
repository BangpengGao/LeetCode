package com.bigbang.old;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/19
 */

public class FindPeakElement {
    /**
     * 162. Find Peak Element
     * Medium
     * <p>
     * A peak element is an element that is greater than its neighbors.
     * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
     * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
     * You may imagine that nums[-1] = nums[n] = -∞.
     * Example 1:
     * Input: nums = [1,2,3,1]
     * Output: 2
     * Explanation: 3 is a peak element and your function should return the index number 2.
     * Example 2:
     * Input: nums = [1,2,1,3,5,6,4]
     * Output: 1 or 5
     * Explanation: Your function can return either index number 1 where the peak element is 2,
     * or index number 5 where the peak element is 6.
     * Note:
     * Your solution should be in logarithmic complexity.
     */

    // 暴力解决，找出第一个合适的，即return
    public int solution(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    // 采用折半的方式
    public int solution2(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int max = 0;
        while (low<high){
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid+1]){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
