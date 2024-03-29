package com.bigbang.old;

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.

Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0
*/
public class MedianOfTwoSortedArrays {
    public double median(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedian(B, A, n, m);
        } else {
            return findMedian(A, B, m, n);
        }
    }

    public double findMedian(int[] A, int[] B, int m, int n) {
        int imin = 0;
        int imax = m;
        int half_len = (m + n + 1) / 2;
        int i = 0;
        int j = 0;
        int max_of_left = 0;
        int min_of_right = 0;
        while (imin <= imax) {
            i = (imin + imax) / 2;
            j = half_len - i;
            if (i < m && B[j - 1] > A[i]) {
                imin = i + 1;
            } else if (i > 0 && A[i - 1] > B[j]) {
                imax = i - 1;
            } else {
                if (i == 0) {
                    max_of_left = B[j - 1];
                } else if (j == 0) {
                    max_of_left = A[i - 1];
                } else {
                    max_of_left = Math.max(A[i - 1], B[j - 1]);
                }

                if ((m + n) % 2 == 1) return max_of_left;

                if (i == m) {
                    min_of_right = B[j];
                } else if (j == n) {
                    min_of_right = A[i];
                } else {
                    min_of_right = Math.min(A[i], B[j]);
                }

                return (max_of_left + min_of_right) / 2.0;
            }
        }
        return -1;
    }
}