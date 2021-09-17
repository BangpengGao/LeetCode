package com.bigbang.sorting;

import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/17
 * @since 1.0.0
 */
public class LeetCode888FairCandySwap {
    /**
     * Alice and Bob have a different total number of candies.
     * You are given two integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith box of candy
     * that Alice has and bobSizes[j] is the number of candies of the jth box of candy that Bob has.
     * Since they are friends, they would like to exchange one candy box each so that after the exchange,
     * they both have the same total amount of candy.
     * The total amount of candy a person has is the sum of the number of candies in each box they have.
     * Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange,
     * and answer[1] is the number of candies in the box that Bob must exchange.
     * If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer exists.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: aliceSizes = [1,1], bobSizes = [2,2]
     * Output: [1,2]
     * <p>
     * Example 2:
     * Input: aliceSizes = [1,2], bobSizes = [2,3]
     * Output: [1,2]
     * <p>
     * Example 3:
     * Input: aliceSizes = [2], bobSizes = [1,3]
     * Output: [2,3]
     * <p>
     * Example 4:
     * Input: aliceSizes = [1,2,5], bobSizes = [2,4]
     * Output: [5,4]
     * <p>
     * <p>
     * Constraints:
     * 1 <= aliceSizes.length, bobSizes.length <= 104
     * 1 <= aliceSizes[i], bobSizes[j] <= 105
     * Alice and Bob have a different total number of candies.
     * There will be at least one valid answer for the given input.
     *
     * @param aliceSizes
     * @param bobSizes
     * @return
     */
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        //Runtime: 16 ms, faster than 49.27% of Java online submissions for Fair Candy Swap.
        //Memory Usage: 59.1 MB, less than 19.81% of Java online submissions for Fair Candy Swap.

        int aSum = 0, bSum = 0, diff = 0;
        for (int a : aliceSizes)
            aSum += a;
        for (int b : bobSizes)
            bSum += b;
        diff = (aSum - bSum) / 2;

        int[] solution = new int[2];
        //二分查找之前必须先进行排序
        Arrays.sort(bobSizes);
        for (int i = 0; i < aliceSizes.length; i++) {
            if (i > 0 && aliceSizes[i] == aliceSizes[i - 1]) continue;
            //二分查找之前必须先进行排序
            int idx = Arrays.binarySearch(bobSizes, aliceSizes[i] - diff);
            if (idx >= 0) {
                solution[0] = aliceSizes[i];
                solution[1] = aliceSizes[i] - diff;
                break;
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] aliceSizes = {35, 17, 4, 24, 10}, bobSizes = {63, 21, 0};
        System.out.println(Arrays.toString(fairCandySwap(aliceSizes, bobSizes)));
    }
}
