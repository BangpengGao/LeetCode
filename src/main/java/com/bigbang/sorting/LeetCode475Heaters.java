package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/31
 * @ Time 15:47
 */
public class LeetCode475Heaters {
    /**
     * Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
     * <p>
     * Every house can be warmed, as long as the house is within the heater's warm radius range.
     * <p>
     * Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
     * <p>
     * Notice that all the heaters follow your radius standard, and the warm radius will the same.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: houses = [1,2,3], heaters = [2]
     * Output: 1
     * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
     * Example 2:
     * <p>
     * Input: houses = [1,2,3,4], heaters = [1,4]
     * Output: 1
     * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
     * Example 3:
     * <p>
     * Input: houses = [1,5], heaters = [2]
     * Output: 3
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= houses.length, heaters.length <= 3 * 104
     * 1 <= houses[i], heaters[i] <= 109
     *
     * @param houses
     * @param heaters
     * @return
     */
    public static int findRadius(int[] houses, int[] heaters) {
        //采用二分查找
        //Runtime: 19 ms, faster than 36.99% of Java online submissions for Heaters.
        //Memory Usage: 52.3 MB, less than 10.40% of Java online submissions for Heaters.

        //Runtime: 9 ms, faster than 83.24% of Java online submissions for Heaters.
        //Memory Usage: 42.2 MB, less than 64.31% of Java online submissions for Heaters.

        Arrays.sort(heaters);
        int count = 0;
        for (int h : houses) {
            int idx = Arrays.binarySearch(heaters, h);
            if (idx < 0)
                idx = ~idx;
            int dist1 = idx - 1 >= 0 ? h - heaters[idx - 1] : Integer.MAX_VALUE;
            int dist2 = idx < heaters.length ? heaters[idx] - h : Integer.MAX_VALUE;

            count = Math.max(count, Math.min(dist1, dist2));
        }

        return count;
    }

    public static int findRadiusV2(int[] houses, int[] heaters) {
        //采用二分查找
        //Runtime: 9 ms, faster than 83.24% of Java online submissions for Heaters.
        //Memory Usage: 42.2 MB, less than 64.31% of Java online submissions for Heaters.

        Arrays.sort(heaters);
        int count = 0;
        for (int h : houses) {
            int idx = Arrays.binarySearch(heaters, h);
            // 减少不必要的操作可以加快速度减少内存
            if (idx < 0) {
                idx = ~idx;
                int dist1 = idx - 1 >= 0 ? h - heaters[idx - 1] : Integer.MAX_VALUE;
                int dist2 = idx < heaters.length ? heaters[idx] - h : Integer.MAX_VALUE;

                count = Math.max(count, Math.min(dist1, dist2));
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[] houses = {1, 2, 3};
        int[] heaters = {2};
        System.out.println(findRadius(houses, heaters));
    }
}
