package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/9
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCost2HireKWorkers {
    /**
     * 857. Minimum Cost to Hire K Workers
     * Hard
     *
     * There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].
     * Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers, we must pay them according to the following rules:
     * Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
     * Every worker in the paid group must be paid at least their minimum wage expectation.
     * Return the least amount of money needed to form a paid group satisfying the above conditions.
     * Example 1:
     * Input: quality = [10,20,5], wage = [70,50,30], K = 2
     * Output: 105.00000
     * Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
     * Example 2:
     * Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
     * Output: 30.66667
     * Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately.
     * Note:
     * 1 <= K <= N <= 10000, where N = quality.length = wage.length
     * 1 <= quality[i] <= 10000
     * 1 <= wage[i] <= 10000
     * Answers within 10^-5 of the correct answer will be considered correct.
     */
    public double solution1(int[] quality, int[] wage, int K) {
        double[][] wqRate = new double[wage.length][2];
        double minWorkerSalary = Double.MAX_VALUE;
        double sumQuality = 0.0;
        for (int i=0; i<wage.length; i++) {
            wqRate[i][0] = quality[i];
            wqRate[i][1] = (double) wage[i] / quality[i];
        }
        Arrays.sort(wqRate, ((a,b)->Double.compare(a[1], b[1])));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b, a));

        for (int i=0; i<wage.length; i++){
            maxHeap.add((int) wqRate[i][0]);
            sumQuality += wqRate[i][0];
            if (maxHeap.size() > K){
                int maxQuality = maxHeap.poll();
                sumQuality -= maxQuality;
            }
            if (maxHeap.size() == K){
                double curRate = wqRate[i][1];
                minWorkerSalary = Double.min(minWorkerSalary, sumQuality * curRate);
            }
        }
        return minWorkerSalary;
    }

    public static void main(String[] args){
        MinimumCost2HireKWorkers m = new MinimumCost2HireKWorkers();
        System.out.println(m.solution1(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
    }
}
