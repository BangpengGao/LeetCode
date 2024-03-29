package com.bigbang.old;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/6
 */

import java.util.HashMap;
import java.util.Map;

public class TriplesWithBitwiseANDEqualToZero {
    /**
     * 982. Triples with Bitwise AND Equal To Zero
     * Hard
     *
     * Given an array of integers A, find the number of triples of indices (i, j, k) such that:
     * 0 <= i < A.length
     * 0 <= j < A.length
     * 0 <= k < A.length
     * A[i] & A[j] & A[k] == 0, where & represents the bitwise-AND operator.
     * Example 1:
     * Input: [2,1,3]
     * Output: 12
     * Explanation: We could choose the following i, j, k triples:
     * (i=0, j=0, k=1) : 2 & 2 & 1
     * (i=0, j=1, k=0) : 2 & 1 & 2
     * (i=0, j=1, k=1) : 2 & 1 & 1
     * (i=0, j=1, k=2) : 2 & 1 & 3
     * (i=0, j=2, k=1) : 2 & 3 & 1
     * (i=1, j=0, k=0) : 1 & 2 & 2
     * (i=1, j=0, k=1) : 1 & 2 & 1
     * (i=1, j=0, k=2) : 1 & 2 & 3
     * (i=1, j=1, k=0) : 1 & 1 & 2
     * (i=1, j=2, k=0) : 1 & 3 & 2
     * (i=2, j=0, k=1) : 3 & 2 & 1
     * (i=2, j=1, k=0) : 3 & 1 & 2
     * Note:
     * 1 <= A.length <= 1000
     * 0 <= A[i] < 2^16
     */
    public int solution1(int[] A) {
        int N = 1 << 16, M = 3;
        int[][] dp = new int[M + 1][N];
        dp[0][N - 1] = 1;
        for (int i = 0; i < M; i++) {
            for (int k = 0; k < N; k++) {
                for (int a : A) {
                    dp[i + 1][k & a] += dp[i][k];
                }
            }
        }
        return dp[M][0];
    }

    public int solution2(int[] A) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int num = A[i] & A[j];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int num : map.keySet()) {
                if ((A[i] & num) == 0) {
                    ans += map.get(num);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TriplesWithBitwiseANDEqualToZero t = new TriplesWithBitwiseANDEqualToZero();
        int[] A = {2,1,3};
        System.out.println(t.solution1(A));
    }
}
