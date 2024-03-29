package com.bigbang.old;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/9/5
 */

public class KthSmallestElementInASortedMatrix {

    /**
     * 378. Kth Smallest Element in a Sorted Matrix
     * Medium
     * <p>
     * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
     * <p>
     * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
     * <p>
     * Example:
     * <p>
     * matrix = [
     * [ 1,  5,  9],
     * [10, 11, 13],
     * [12, 13, 15]
     * ],
     * k = 8,
     * <p>
     * return 13.
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ n2.
     */
    public static int solution(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[][] sss = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(solution(sss, 8));
    }
}
