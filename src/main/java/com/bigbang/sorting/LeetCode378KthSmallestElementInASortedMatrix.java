package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/27
 * @ Time 11:06
 */
public class LeetCode378KthSmallestElementInASortedMatrix {
    /**
     * Given an n x n matrix where each of the rows and columns are sorted in ascending order,
     * return the kth smallest element in the matrix.
     * <p>
     * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
     * Output: 13
     * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
     * Example 2:
     * <p>
     * Input: matrix = [[-5]], k = 1
     * Output: -5
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == matrix.length
     * n == matrix[i].length
     * 1 <= n <= 300
     * -109 <= matrix[i][j] <= 109
     * All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
     * 1 <= k <= n2
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        //Runtime: 10 ms, faster than 67.54% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
        //Memory Usage: 56 MB, less than 5.03% of Java online submissions for Kth Smallest Element in a Sorted Matrix.

        int[] flat = new int[matrix.length * matrix[0].length];
        int flag = 0;
        for (int[] m : matrix)
            for (int n : m)
                flat[flag++] = n;
        Arrays.sort(flat);
        return flat[k - 1];
    }

    public static int kthSmallestV2(int[][] matrix, int k) {
        // 最小值加上最大最小值的差值的一半为mid
        // 如果查询到ints[j] > mid时，且个数小于k，则置lo为mid+1，反之hi=mid

        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int[] ints : matrix) {
                while (j >= 0 && ints[j] > mid) j--;
                count += (j + 1);
            }
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest(matrix, 8));
    }
}
