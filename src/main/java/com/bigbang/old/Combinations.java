package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/13
 */

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /**
     * 77. Combinations
     * Medium
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * Example:
     * Input: n = 4, k = 2
     * Output:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> solution1(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combinate(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    public List<List<Integer>> solution2(int n, int k){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = solution2(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(solution2(n - 1, k));
        return result;
    }

    private void combinate(List<List<Integer>> res, List<Integer> temp, int start, int n, int k) {
        if(k==0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=start;i<=n;i++) {
            temp.add(i);
            combinate(res, temp, i+1, n, k-1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] arg){
        Combinations combinations = new Combinations();
        System.out.println(combinations.solution1(13, 10));
    }
}
