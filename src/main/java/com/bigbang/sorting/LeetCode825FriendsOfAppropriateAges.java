package com.bigbang.sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/15
 * @since 1.0.0
 */
public class LeetCode825FriendsOfAppropriateAges {
    /**
     * There are n persons on a social media website. You are given an integer array ages where ages[i] is the age of the ith person.
     * <p>
     * A Person x will not send a friend request to a person y (x != y) if any of the following conditions is true:
     * <p>
     * age[y] <= 0.5 * age[x] + 7
     * age[y] > age[x]
     * age[y] > 100 && age[x] < 100
     * Otherwise, x will send a friend request to y.
     * <p>
     * Note that if x sends a request to y, y will not necessarily send a request to x.
     * Also, a person will not send a friend request to themself.
     * <p>
     * Return the total number of friend requests made.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: ages = [16,16]
     * Output: 2
     * Explanation: 2 people friend request each other.
     * Example 2:
     * <p>
     * Input: ages = [16,17,18]
     * Output: 2
     * Explanation: Friend requests are made 17 -> 16, 18 -> 17.
     * Example 3:
     * <p>
     * Input: ages = [20,30,100,110,120]
     * Output: 3
     * Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == ages.length
     * 1 <= n <= 2 * 104
     * 1 <= ages[i] <= 120
     *
     * @param ages
     * @return
     */
    public static int numFriendRequests(int[] ages) {
        //Runtime: 53 ms, faster than 13.85% of Java online submissions for Friends Of Appropriate Ages.
        //Memory Usage: 54.3 MB, less than 7.01% of Java online submissions for Friends Of Appropriate Ages.
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int age : ages)
            map.put(age, map.getOrDefault(age, 0) + 1);

        int solution = 0;
        for (Integer a : map.keySet())
            for (Integer b : map.keySet())
                if (!isSend(a, b)) solution += map.get(a) * (map.get(b) - (a.equals(b) ? 1 : 0));
        return solution;
    }

    public static boolean isSend(int x, int y) {
        return y <= (0.5 * x + 7) || y > x || (y > 100 && x < 100);
    }

    public static void main(String[] args) {
        int[] nums = {16, 16};
        System.out.println(numFriendRequests(nums));
    }
}
