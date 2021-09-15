package com.bigbang.sorting;

import java.awt.*;
import java.util.Arrays;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/15
 * @since 1.0.0
 */
public class LeetCode826MostProfitAssigningWork {
    /**
     * You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
     * <p>
     * difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
     * worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
     * Every worker can be assigned at most one job, but one job can be completed multiple times.
     * <p>
     * For example, if three workers attempt the same job that pays $1, then the total profit will be $3.
     * If a worker cannot complete any job, their profit is $0.
     * Return the maximum profit we can achieve after assigning the workers to the jobs.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
     * Output: 100
     * Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.
     * Example 2:
     * <p>
     * Input: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == difficulty.length
     * n == profit.length
     * m == worker.length
     * 1 <= n, m <= 104
     * 1 <= difficulty[i], profit[i], worker[i] <= 105
     *
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //暴力解决
        //Runtime: 1878 ms, faster than 5.01% of Java online submissions for Most Profit Assigning Work.
        //Memory Usage: 54.1 MB, less than 20.05% of Java online submissions for Most Profit Assigning Work.

        int solution = 0;
        for (int w : worker) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < difficulty.length; i++) {
                if (difficulty[i] <= w && profit[i] > max) {
                    max = profit[i];
                }
            }
            if (max != Integer.MIN_VALUE) {
                solution += max;
            }
        }

        return solution;
    }

    public static int maxProfitAssignmentV2(int[] difficulty, int[] profit, int[] worker) {
        //Runtime: 24 ms, faster than 59.67% of Java online submissions for Most Profit Assigning Work.
        //Memory Usage: 56.1 MB, less than 19.09% of Java online submissions for Most Profit Assigning Work.

        int len = difficulty.length;
        Point[] points = new Point[len];
        for (int i = 0; i < len; i++)
            points[i] = new Point(difficulty[i], profit[i]);

        Arrays.sort(points, (a, b) -> a.x - b.x);
        Arrays.sort(worker);
        int solution = 0, idx = 0, max = 0;
        for (int w : worker) {
            while (idx < len && w >= points[idx].x)
                max = Math.max(max, points[idx++].y);
            solution += max;
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] difficulty = {2, 4, 6, 8, 10}, profit = {10, 20, 30, 40, 50}, worker = {4, 5, 6, 7};
        System.out.println(maxProfitAssignmentV2(difficulty, profit, worker));

        int[] difficulty1 = {49, 49, 76, 88, 100},
                profit1 = {5, 8, 75, 89, 94},
                worker1 = {98, 72, 16, 27, 76};
        System.out.println(maxProfitAssignmentV2(difficulty1, profit1, worker1));
    }
}
