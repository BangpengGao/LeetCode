package com.bigbang.sorting;

import java.util.*;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/26
 * @ Time 9:08
 */
public class LeetCode349IntersectionOfTwoArrays {
    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must be unique and you may return the result in any order.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     * Example 2:
     * <p>
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     * Explanation: [4,9] is also accepted.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums1.length, nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 1000
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        //Runtime: 4 ms, faster than 28.92% of Java online submissions for Intersection of Two Arrays.
        //Memory Usage: 39.6 MB, less than 13.47% of Java online submissions for Intersection of Two Arrays.

        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int n : nums1)
            if (!numsMap.containsKey(n))
                numsMap.put(n, 1);
        for (int n : nums2)
            if (numsMap.containsKey(n))
                numsMap.put(n, numsMap.getOrDefault(n, 0) + 1);

        List<Integer> solution = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numsMap.entrySet())
            if (entry.getValue() > 1)
                solution.add(entry.getKey());
        return solution.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
        int[] nums3 = {4, 9, 5}, nums4 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums3, nums4)));
    }
}
