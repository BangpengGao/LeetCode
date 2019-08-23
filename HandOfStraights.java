package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/23
 */

import java.util.TreeMap;

public class HandOfStraights {
    /**
     * 846. Hand of Straights
     * Medium
     * <p>
     * Alice has a hand of cards, given as an array of integers.
     * <p>
     * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
     * <p>
     * Return true if and only if she can.
     * <p>
     * Example 1:
     * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
     * Output: true
     * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
     * Example 2:
     * Input: hand = [1,2,3,4,5], W = 4
     * Output: false
     * Explanation: Alice's hand can't be rearranged into groups of 4.
     * <p>
     * Note:
     * 1 <= hand.length <= 10000
     * 0 <= hand[i] <= 10^9
     * 1 <= W <= hand.length
     */

    // brute force
    public boolean solution(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        TreeMap<Integer, Integer> handMap = new TreeMap<>();
        for (int hi : hand) {
            if (handMap.containsKey(hi))
                handMap.replace(hi, handMap.get(hi) + 1);
            else handMap.put(hi, 1);
        }
        while (handMap.size() > 0) {
            int header = handMap.firstKey();
            for (int c = header; c < header + W; ++c) {
                if (!handMap.containsKey(c)) return false;
                int cValue = handMap.get(c);
                if (cValue == 1) handMap.remove(c);
                else handMap.replace(c, cValue - 1);
            }
        }
        return true;
    }
}
