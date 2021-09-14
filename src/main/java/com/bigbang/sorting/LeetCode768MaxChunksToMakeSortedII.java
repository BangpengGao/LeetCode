package com.bigbang.sorting;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/13
 * @since 1.0.0
 */
public class LeetCode768MaxChunksToMakeSortedII {

    /**
     * You are given an integer array arr.
     * <p>
     * We split arr into some number of chunks (i.e., partitions), and individually sort each chunk.
     * After concatenating them, the result should equal the sorted array.
     * <p>
     * Return the largest number of chunks we can make to sort the array.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: arr = [5,4,3,2,1]
     * Output: 1
     * Explanation:
     * Splitting into two or more chunks will not return the required result.
     * For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
     * Example 2:
     * <p>
     * Input: arr = [2,1,3,4,4]
     * Output: 4
     * Explanation:
     * We can split into two chunks, such as [2, 1], [3, 4, 4].
     * However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= arr.length <= 2000
     * 0 <= arr[i] <= 108
     *
     * @param arr
     * @return
     */
    public static int maxChunksToSorted(int[] arr) {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Max Chunks To Make Sorted II.
        //Memory Usage: 38.4 MB, less than 88.36% of Java online submissions for Max Chunks To Make Sorted II.
        
        int len = arr.length;
        int[] minOfRight = new int[len];
        minOfRight[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--)
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);

        int solution = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(arr[i], max);
            if (minOfRight[i + 1] >= max) solution++;
        }
        return solution + 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 4};
        System.out.println(maxChunksToSorted(arr));

        int[] arr1 = {1, 1, 1, 0, 1, 0, 0, 0, 1, 0};
        System.out.println(maxChunksToSorted(arr1));
    }
}
