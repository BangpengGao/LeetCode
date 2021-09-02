package com.bigbang.sorting;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/9/2
 * @ Time 9:47
 */
public class LeetCode506RelativeRanks {


    /**
     * You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition.
     * All the scores are guaranteed to be unique.
     * <p>
     * The athletes are placed based on their scores, where the 1st place athlete has the highest score,
     * the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
     * <p>
     * The 1st place athlete's rank is "Gold Medal".
     * The 2nd place athlete's rank is "Silver Medal".
     * The 3rd place athlete's rank is "Bronze Medal".
     * For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
     * Return an array answer of size n where answer[i] is the rank of the ith athlete.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: score = [5,4,3,2,1]
     * Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
     * Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
     * Example 2:
     * <p>
     * Input: score = [10,3,8,9,4]
     * Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
     * Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == score.length
     * 1 <= n <= 104
     * 0 <= score[i] <= 106
     * All the values in score are unique.
     *
     * @param score
     * @return
     */
    public static String[] findRelativeRanks(int[] score) {
        //Runtime: 11 ms, faster than 60.25% of Java online submissions for Relative Ranks.
        //Memory Usage: 40 MB, less than 78.31% of Java online submissions for Relative Ranks.

        String[] solution = new String[score.length];
        if (score.length == 0) return solution;

        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < score.length; i++)
            integerMap.put(score[i], i);
        List<Integer> order = integerMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        for (int i = 0; i < order.size(); i++) {
            //"Gold Medal","Silver Medal","Bronze Medal"
            if (i == 0)
                solution[order.get(i)] = "Gold Medal";
            else if (i == 1)
                solution[order.get(i)] = "Silver Medal";
            else if (i == 2)
                solution[order.get(i)] = "Bronze Medal";
            else
                solution[order.get(i)] = String.valueOf(i+1);
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] score = {10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }
}
