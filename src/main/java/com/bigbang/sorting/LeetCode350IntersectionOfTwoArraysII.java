package com.bigbang.sorting;

import java.util.*;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/26
 * @ Time 9:28
 */
public class LeetCode350IntersectionOfTwoArraysII {

    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     * Example 2:
     * <p>
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Explanation: [9,4] is also accepted.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums1.length, nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 1000
     * <p>
     * <p>
     * Follow up:
     * <p>
     * What if the given array is already sorted? How would you optimize your algorithm?
     * What if nums1's size is small compared to nums2's size? Which algorithm is better?
     * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        //Runtime: 11 ms, faster than 5.52% of Java online submissions for Intersection of Two Arrays II.
        //Memory Usage: 41.1 MB, less than 5.80% of Java online submissions for Intersection of Two Arrays II.

        Map<Integer, Integer> nums1Map = new HashMap<>();
        Map<Integer, Integer> nums2Map = new HashMap<>();
        for (int n : nums1)
            nums1Map.put(n, nums1Map.getOrDefault(n, 0) + 1);
        for (int n : nums2)
            nums2Map.put(n, nums2Map.getOrDefault(n, 0) + 1);

        List<Integer> solution = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : nums1Map.entrySet()) {
            if (nums2Map.containsKey(entry.getKey())) {
                int min = Math.min(entry.getValue(), nums2Map.get(entry.getKey()));
                for (int i = 0; i < min; i++)
                    solution.add(entry.getKey());
            }
        }
        return solution.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] intersectV2(int[] nums1, int[] nums2) {
        //Runtime: 11 ms, faster than 5.52% of Java online submissions for Intersection of Two Arrays II.
        //Memory Usage: 40.4 MB, less than 10.08% of Java online submissions for Intersection of Two Arrays II.

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> solution = new ArrayList<>();
        int low = 0, high = 0;
        while (low < nums1.length && high < nums2.length) {
            if (nums1[low] == nums2[high]) {
                solution.add(nums1[low]);
                low++;
                high++;
            } else if (nums1[low] > nums2[high])
                high++;
            else
                low++;
        }
        return solution.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        System.out.println(Arrays.toString(intersectV2(nums1, nums2)));
        int[] nums3 = {4, 9, 5}, nums4 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersectV2(nums3, nums4)));
    }
}
