package com.bigbang.sorting;

import java.util.*;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/17
 * @since 1.0.0
 */
public class LeetCode870AdvantageShuffle {
    /**
     * You are given two integer arrays nums1 and nums2 both of the same length.
     * The advantage of nums1 with respect to nums2 is the number of indices i for which nums1[i] > nums2[i].
     * Return any permutation of nums1 that maximizes its advantage with respect to nums2.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
     * Output: [2,11,7,15]
     * <p>
     * Example 2:
     * Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
     * Output: [24,32,8,12]
     * <p>
     * <p>
     * Constraints:
     * 1 <= nums1.length <= 105
     * nums2.length == nums1.length
     * 0 <= nums1[i], nums2[i] <= 109
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        //经典贪心，解决局部最优解
        //Runtime: 60 ms, faster than 80.65% of Java online submissions for Advantage Shuffle.
        //Memory Usage: 66.2 MB, less than 35.42% of Java online submissions for Advantage Shuffle.

        int[] a = nums1.clone();
        Arrays.sort(a);
        int[] b = nums2.clone();
        Arrays.sort(b);

        Map<Integer, Deque<Integer>> map = new HashMap<>();
        for (int bi : b) map.put(bi, new LinkedList<>());

        Deque<Integer> remain = new LinkedList<>();
        int j = 0;
        for (int ai : a) {
            if (ai > b[j]) {
                map.get(b[j++]).add(ai);
            } else {
                remain.add(ai);
            }
        }

        int[] solution = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums2[i]).size() > 0) {
                solution[i] = map.get(nums2[i]).pop();
            } else {
                solution[i] = remain.pop();
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15}, nums2 = {1, 10, 4, 11};
        System.out.println(Arrays.toString(advantageCount(nums1, nums2)));

        int[] nums3 = {12, 24, 8, 32}, nums4 = {13, 25, 32, 11};
        System.out.println(Arrays.toString(advantageCount(nums3, nums4)));
    }
}
