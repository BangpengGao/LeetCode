package com.bigbang.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/9
 * @since 1.0.0
 */
public class LeetCode658FindKClosestElements {
    /**
     * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
     * The result should also be sorted in ascending order.
     * <p>
     * An integer a is closer to x than an integer b if:
     * <p>
     * |a - x| < |b - x|, or
     * |a - x| == |b - x| and a < b
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: arr = [1,2,3,4,5], k = 4, x = 3
     * Output: [1,2,3,4]
     * Example 2:
     * <p>
     * Input: arr = [1,2,3,4,5], k = 4, x = -1
     * Output: [1,2,3,4]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= k <= arr.length
     * 1 <= arr.length <= 104
     * arr is sorted in ascending order.
     * -104 <= arr[i], x <= 104
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        //二分查找
        //Runtime: 4 ms, faster than 64.19% of Java online submissions for Find K Closest Elements.
        //Memory Usage: 40.2 MB, less than 99.11% of Java online submissions for Find K Closest Elements.

        int l = 0, h = arr.length - k;
        while (l < h) {
            int mid = (h + l) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return Arrays.stream(arr, l, l + k).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(findClosestElements(arr, 4, 3).toString());
        System.out.println(findClosestElements(arr, 4, -1).toString());
    }
}
