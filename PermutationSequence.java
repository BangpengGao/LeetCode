package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/22
 */

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    /**
     * 60. Permutation Sequence
     * Medium
     *
     * The set [1,2,3,...,n] contains a total of n! unique permutations.
     * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     *
     * Note:
     *
     * Given n will be between 1 and 9 inclusive.
     * Given k will be between 1 and n! inclusive.
     * Example 1:
     *
     * Input: n = 3, k = 3
     * Output: "213"
     * Example 2:
     *
     * Input: n = 4, k = 9
     * Output: "2314"
     */

    // 此方法会出现TLE
    public String solution(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        permutation(res,new ArrayList<>(), n, k);
        List<Integer> r = res.get(k-1);
        StringBuilder result = new StringBuilder();
        for (Integer i : r){
            result.append(i);
        }
        return result.toString();
    }

    public void permutation(List<List<Integer>> rrr,List<Integer> res, int n, int k){
        if (res.size() == n){
            rrr.add(new ArrayList<>(res));
        }
        for (int i=1; i<=n; i++){
            if (res.contains(i)) continue;
            if (rrr.size() >= k) break;
            res.add(i);
            permutation(rrr, res, n, k);
            res.remove(res.size()-1);
        }
    }

    public String solution2(int n,int k){
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}
        k--;
        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[n-i];
        }
        return String.valueOf(sb);
    }

    public static void main(String[] arg){
        PermutationSequence p = new PermutationSequence();
        System.out.println(p.solution(3,3));
    }
}
