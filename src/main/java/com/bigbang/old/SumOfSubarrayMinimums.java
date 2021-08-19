package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/9/2
 */

import java.util.PriorityQueue;
import java.util.Stack;

public class SumOfSubarrayMinimums {
    /**
     * 907. Sum of Subarray Minimums
     * Medium
     * <p>
     * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
     * <p>
     * Since the answer may be large, return the answer modulo 10^9 + 7.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,1,2,4]
     * Output: 17
     * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
     * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
     * <p>
     * Note:
     * <p>
     * 1 <= A.length <= 30000
     * 1 <= A[i] <= 30000
     */

    private static final int MODULO = 1000000007;

    //暴力直接的方法出现TLE错误
    public static int solution(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            PriorityQueue<Integer> prq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
            int t = i;
            while (t < A.length) {
                if (!prq.isEmpty() && prq.peek() < A[t]) {
                    res = (res + prq.peek()) % MODULO;
                } else {
                    prq.add(A[t]);
                    res = (res + prq.peek()) % MODULO;
                }
                t++;
            }
            prq.clear();
        }
        return res;
    }

    // 解题思想（用一个栗子🌰来说明吧）：
    // A = ｛3,1,2,4｝,i为浏览索引，初始值为0
    // ①采用栈暂时存储数据，i=0时，栈为空，直接将索引i=0存入栈中
    // ②i=1时，栈顶的值称为si，A[si]大于A[i]，则i>=1以后的子数组中，最小值均小于A[si]
    // ③依次取出栈中索引，并计算出产生的子数组的个数，将值与个数相乘加入返回值中。
    // ④将A[i]推入栈中，再次进行①-③的操作
    // ⑤返回值
    public static int solution2(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length, res = 0, mod = (int) 1e9 + 7, j, k;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > (i == n ? 0 : A[i])) {
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                res = (res + A[j] * (i - j) * (j - k)) % mod;
            }
            stack.push(i);
        }
        return res;
    }

}
