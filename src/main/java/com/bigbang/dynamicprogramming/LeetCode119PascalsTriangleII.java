package com.bigbang.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/8
 * @since 1.0.0
 */
public class LeetCode119PascalsTriangleII {
    /**
     * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
     * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: rowIndex = 3
     * Output: [1,3,3,1]
     * <p>
     * Example 2:
     * Input: rowIndex = 0
     * Output: [1]
     * <p>
     * Example 3:
     * Input: rowIndex = 1
     * Output: [1,1]
     * <p>
     * <p>
     * Constraints:
     * 0 <= rowIndex <= 33
     * <p>
     * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
     *
     * @param numRows
     * @return
     */
    public static List<Integer> getRow(int numRows) {
        //杨辉三角
        //Runtime: 1 ms, faster than 78.25% of Java online submissions for Pascal's Triangle II.
        //Memory Usage: 36.8 MB, less than 58.91% of Java online submissions for Pascal's Triangle II.

        numRows = numRows + 1;
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

        return solution.get(numRows - 1);
    }

    public static List<Integer> getRowV2(int rowIndex) {
        //杨辉三角
        //Runtime: 1 ms, faster than 78.25% of Java online submissions for Pascal's Triangle II.
        //Memory Usage: 36.7 MB, less than 77.59% of Java online submissions for Pascal's Triangle II.

        rowIndex = rowIndex + 1;
        List<Integer> solution = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>(i);
            temp.add(1);
            if (i == 2) {
                temp.add(1);
            } else if (i > 2) {
                temp.add(1);
                int n = i % 2 == 0 ? i / 2 - 1 : i / 2;
                for (int k = 1; k <= n; k++) {
                    int t = solution.get(k - 1) + solution.get(k);
                    temp.add(k, t);
                    if (k != n || i % 2 == 0) {
                        temp.add(k, t);
                    }
                }
            }
            solution = temp;
        }

        return solution;
    }

    public static void main(String[] args) {
        System.out.println(getRowV2(2));
    }
}
