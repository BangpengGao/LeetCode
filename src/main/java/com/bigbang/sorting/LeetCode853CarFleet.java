package com.bigbang.sorting;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/16
 * @since 1.0.0
 */
public class LeetCode853CarFleet {
    /**
     * There are n cars going to the same destination along a one-lane road. The destination is target miles away.
     * <p>
     * You are given two integer array position and speed, both of length n,
     * where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
     * <p>
     * A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
     * <p>
     * The distance between these two cars is ignored (i.e., they are assumed to have the same position).
     * <p>
     * A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.
     * <p>
     * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
     * <p>
     * Return the number of car fleets that will arrive at the destination.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
     * Output: 3
     * Explanation:
     * The cars starting at 10 and 8 become a fleet, meeting each other at 12.
     * The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
     * The cars starting at 5 and 3 become a fleet, meeting each other at 6.
     * Note that no other cars meet these fleets before the destination, so the answer is 3.
     * Example 2:
     * <p>
     * Input: target = 10, position = [3], speed = [3]
     * Output: 1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == position.length == speed.length
     * 1 <= n <= 105
     * 0 < target <= 106
     * 0 <= position[i] < target
     * All the values of position are unique.
     * 0 < speed[i] <= 106
     *
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public static int carFleet(int target, int[] position, int[] speed) {
        //Runtime: 218 ms, faster than 5.63% of Java online submissions for Car Fleet.
        //Memory Usage: 123 MB, less than 5.92% of Java online submissions for Car Fleet.

        Map<Integer, Double> m = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; ++i)
            m.put(position[i], (double) (target - position[i]) / speed[i]);
        int res = 0;
        double cur = 0;
        for (double time : m.values()) {
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3}, speed = {2, 4, 1, 1, 3};
        System.out.println(carFleet(target, position, speed));
    }
}
