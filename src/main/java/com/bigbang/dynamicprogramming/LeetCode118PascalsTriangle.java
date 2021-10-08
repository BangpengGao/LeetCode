package com.bigbang.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/8
 * @since 1.0.0
 */
public class LeetCode118PascalsTriangle {
    /**
     * Given an integer numRows, return the first numRows of Pascal's triangle.
     * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
     * <p>
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: numRows = 5
     * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * <p>
     * Example 2:
     * Input: numRows = 1
     * Output: [[1]]
     * <p>
     * Constraints:
     * 1 <= numRows <= 30
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        //杨辉三角
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
        //Memory Usage: 37.3 MB, less than 39.78% of Java online submissions for Pascal's Triangle.
        List<List<Integer>> solution = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>(i);
            temp.add(1);
            if (i == 1) {
                solution.add(temp);
                continue;
            } else if (i == 2) {
                temp.add(1);
                solution.add(temp);
                continue;
            }
            temp.add(1);
            List<Integer> last = solution.get(solution.size() - 1);
            int n = i % 2 == 0 ? i / 2 - 1 : i / 2;
            for (int k = 1; k <= n; k++) {
                int t = last.get(k - 1) + last.get(k);
                temp.add(k, t);
                if (k != n || i % 2 == 0) {
                    temp.add(k, t);
                }
            }
            solution.add(temp);
        }

        return solution;
    }

    public static void main(String[] args) {
        System.out.println(generate(8));
    }
}
