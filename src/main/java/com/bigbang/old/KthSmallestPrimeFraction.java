package com.bigbang.old;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/30
 */

import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    /**
     * 786. K-th Smallest Prime Fraction
     * Hard
     * <p>
     * A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.
     * <p>
     * What is the K-th smallest fraction considered?  Return your answer as an array of ints, where answer[0] = p and answer[1] = q.
     * <p>
     * Examples:
     * Input: A = [1, 2, 3, 5], K = 3
     * Output: [2, 5]
     * Explanation:
     * The fractions to be considered in sorted order are:
     * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
     * The third fraction is 2/5.
     * <p>
     * Input: A = [1, 7], K = 1
     * Output: [1, 7]
     * Note:
     * <p>
     * A will have length between 2 and 2000.
     * Each A[i] will be between 1 and 30000.
     * K will be between 1 and A.length * (A.length - 1) / 2.
     */

    // 利用PriorityQueue的特性
    // 将分子分母以数组的形式放在PriorityQueue中
    // 循环减少分母的值，直到PriorityQueue的顶端为第K大的值
    // 使用peek取出

    public int[] solution(int[] A, int K) {
        int N = A.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return A[a[0]] * A[b[1]] - A[b[0]] * A[a[1]];
        });
        for (int i = 0; i < N - 1 && i < K; i++) {
            pq.add(new int[]{i, N - 1});
        }
        for (int i = 0; i < K - 1; i++) {
            int[] cur = pq.remove();
            if (cur[1] - 1 > cur[0]) {
                cur[1]--;
                pq.add(cur);
            }
        }
        return new int[]{A[pq.peek()[0]], A[pq.peek()[1]]};
    }
}
