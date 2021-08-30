package com.bigbang.sorting;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/30
 * @ Time 13:47
 */
public class LeetCode414ThirdMaximumNumber {
    /**
     * Given an integer array nums, return the third distinct maximum number in this array.
     * If the third maximum does not exist, return the maximum number.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,2,1]
     * Output: 1
     * Explanation:
     * The first distinct maximum is 3.
     * The second distinct maximum is 2.
     * The third distinct maximum is 1.
     * Example 2:
     * <p>
     * Input: nums = [1,2]
     * Output: 2
     * Explanation:
     * The first distinct maximum is 2.
     * The second distinct maximum is 1.
     * The third distinct maximum does not exist, so the maximum (2) is returned instead.
     * Example 3:
     * <p>
     * Input: nums = [2,2,3,1]
     * Output: 1
     * Explanation:
     * The first distinct maximum is 3.
     * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
     * The third distinct maximum is 1.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     * <p>
     * <p>
     * Follow up: Can you find an O(n) solution?
     *
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        //Runtime: 6 ms, faster than 18.85% of Java online submissions for Third Maximum Number.
        //Memory Usage: 39.2 MB, less than 19.46% of Java online submissions for Third Maximum Number.

        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums)
            set.add(n);
        List<Integer> list = set.stream().sorted().collect(Collectors.toList());
        if (list.size() < 3) return list.get(list.size() - 1);
        return list.get(list.size() - 3);
    }

    public static int thirdMaxV2(int[] nums) {
        //Runtime: 16 ms, faster than 7.08% of Java online submissions for Third Maximum Number.
        //Memory Usage: 42.7 MB, less than 5.26% of Java online submissions for Third Maximum Number.
        
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
            if (set.size() > 3)
                set.remove(Collections.min(set));
        }

        if (set.size() == 3)
            return Collections.min(set);
        return Collections.max(set);
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        System.out.println(thirdMax(nums));
        System.out.println(thirdMaxV2(nums));
    }
}
