package com.bigbang.sorting;

import java.util.*;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/7
 * @since 1.0.0
 */
public class LeetCode632SmallestRangeCoveringElementsFromKLists {
    /**
     * You have k lists of sorted integers in non-decreasing order.
     * Find the smallest range that includes at least one number from each of the k lists.
     * <p>
     * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
     * Output: [20,24]
     * Explanation:
     * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
     * List 2: [0, 9, 12, 20], 20 is in range [20,24].
     * List 3: [5, 18, 22, 30], 22 is in range [20,24].
     * Example 2:
     * <p>
     * Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
     * Output: [1,1]
     * Example 3:
     * <p>
     * Input: nums = [[10,10],[11,11]]
     * Output: [10,11]
     * Example 4:
     * <p>
     * Input: nums = [[10],[11]]
     * Output: [10,11]
     * Example 5:
     * <p>
     * Input: nums = [[1],[2],[3],[4],[5],[6],[7]]
     * Output: [1,7]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * nums.length == k
     * 1 <= k <= 3500
     * 1 <= nums[i].length <= 50
     * -105 <= nums[i][j] <= 105
     * nums[i] is sorted in non-decreasing order.
     *
     * @param nums
     * @return
     */
    public static int[] smallestRange(List<List<Integer>> nums) {
        // Runtime: 23 ms, faster than 91.17% of Java online submissions for Smallest Range Covering Elements from K Lists.
        // Memory Usage: 44.1 MB, less than 79.04% of Java online submissions for Smallest Range Covering Elements from K Lists.

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(nums.size(), new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int max = nums.get(0).get(0);
        for (int i = 0; i < nums.size(); i++) {
            queue.offer(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(nums.get(i).get(0), max);
        }

        int range = Integer.MAX_VALUE, start = -1;
        while (queue.size() == nums.size()) {
            int[] temp = queue.poll();
            if (max - temp[0] < range) {
                range = max - temp[0];
                start = temp[0];
            }

            if (temp[2] + 1 < nums.get(temp[1]).size()) {
                temp[0] = nums.get(temp[1]).get(temp[2] + 1);
                temp[2]++;
                queue.offer(temp);
                max = Math.max(max, temp[0]);
            }
        }
        return new int[]{start, start + range};
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        int[][] t = {{4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}};
        for (int i = 0; i < t.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < t[i].length; j++) {
                list.add(t[i][j]);
            }
            nums.addAll(Collections.singleton(list));
        }

        System.out.println(Arrays.toString(smallestRange(nums)));
    }
}
