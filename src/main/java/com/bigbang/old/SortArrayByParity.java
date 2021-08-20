package com.bigbang.old;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/19
 */

public class SortArrayByParity {
    /**
     * 905. SortAlgorithm Array By Parity
     * Easy
     *
     * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
     * You may return any answer array that satisfies this condition.
     *
     * Example 1:
     *
     * Input: [3,1,2,4]
     * Output: [2,4,3,1]
     * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
     *
     * Note:
     * 1 <= A.length <= 5000
     * 0 <= A[i] <= 5000
     */
    public int[] solution(int[] A) {
        int[] even = new int[A.length];
        int head = 0, tail = A.length - 1;
        for (int a : A) {
            if (a % 2 == 0) {
                even[head++] = a;
            } else {
                even[tail--] = a;
            }
        }
        return even;
    }
}
