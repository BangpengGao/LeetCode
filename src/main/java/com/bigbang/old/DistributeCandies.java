package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/27
 */

import java.util.HashSet;

public class DistributeCandies {
    /**
     * 575. Distribute Candies
     * Easy
     * <p>
     * Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
     * Example 1:
     * Input: candies = [1,1,2,2,3,3]
     * Output: 3
     * Explanation:
     * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
     * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
     * The sister has three different kinds of candies.
     * Example 2:
     * Input: candies = [1,1,2,3]
     * Output: 2
     * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
     * The sister has two different kinds of candies, the brother has only one kind of candies.
     * Note:
     * <p>
     * The length of the given array is in range [2, 10,000], and will be even.
     * The number in given array is in range [-100,000, 100,000].
     */

    /**
     * 题目的目的就是将数组分为两份，一份中重复的数据最少
     */
    public static int solution(int[] candies) {
        HashSet cands = new HashSet();
        for (int c : candies)
            cands.add(c);
        if (cands.size() >= candies.length / 2) return candies.length / 2;
        return cands.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3}));
    }
}
