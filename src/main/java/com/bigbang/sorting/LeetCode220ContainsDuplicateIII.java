package com.bigbang.sorting;

import java.util.HashMap;
import java.util.Map;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/23
 * @ Time 15:05
 */
public class LeetCode220ContainsDuplicateIII {

    /**
     * Given an integer array nums and two integers k and t,
     * return true if there are two distinct indices i and j in the array
     * such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,1], k = 3, t = 0
     * Output: true
     * Example 2:
     * <p>
     * Input: nums = [1,0,1,1], k = 1, t = 2
     * Output: true
     * Example 3:
     * <p>
     * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
     * Output: false
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= nums.length <= 2 * 10 4
     * -2 31 <= nums[i] <= 2 31 - 1
     * 0 <= k <= 10 4
     * 0 <= t <= 2 31 - 1
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 主要的坑，就是需要注意int类型的负数最大值和正数的最大值
        //Runtime: 18 ms, faster than 92.60% of Java online submissions for Contains Duplicate III.
        //Memory Usage: 42.3 MB, less than 54.90% of Java online submissions for Contains Duplicate III.

        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long) nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

    private static long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2, t = 3;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));

        int[] nums1 = {-2147483648, 2147483647};
        int k1 = 1, t1 = 1;
        System.out.println(containsNearbyAlmostDuplicate(nums1, k1, t1));
    }
}
