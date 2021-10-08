package com.bigbang.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/8
 * @since 1.0.0
 */
public class LeetCode120Triangle {
    /**
     * Given a triangle array, return the minimum path sum from top to bottom.
     * For each step, you may move to an adjacent number of the row below.
     * More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * Output: 11
     * Explanation: The triangle looks like:
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
     * <p>
     * Example 2:
     * Input: triangle = [[-10]]
     * Output: -10
     * <p>
     * <p>
     * Constraints:
     * 1 <= triangle.length <= 200
     * triangle[0].length == 1
     * triangle[i].length == triangle[i - 1].length + 1
     * -104 <= triangle[i][j] <= 104
     * <p>
     * <p>
     * Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        //正向，从上往下，会出现选择idx-1的情况而出现错误答案，实际只能选择idx和idx+1
        int[] solution = new int[triangle.size()];
        solution[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            int temp = i;
            solution[temp] = solution[temp - 1] + triangle.get(i).get(temp);
            temp--;
            while (temp >= 0) {
                System.out.println(i + "," + temp);
                if (triangle.get(i).get(temp) < triangle.get(i).get(temp + 1)) {
                    solution[temp] += triangle.get(i).get(temp);
                } else {
                    solution[temp] += triangle.get(i).get(temp + 1);
                }
                temp--;
            }
        }
        System.out.println(Arrays.toString(solution));
        return Arrays.stream(solution).min().getAsInt();
    }

    public static int minimumTotalV2(List<List<Integer>> triangle) {
        //采用dp，自下而上，进行处理
        //Runtime: 5 ms, faster than 43.01% of Java online submissions for Triangle.
        //Memory Usage: 39.2 MB, less than 47.07% of Java online submissions for Triangle.
        
        for (int i = triangle.size() - 2; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        triangle.add(list);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(2);
        triangle.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(-3);
        list2.add(1);
        list2.add(-1);
        triangle.add(list2);
//        List<Integer> list3 = new ArrayList<>();
//        list3.add(4);
//        list3.add(1);
//        list3.add(8);
//        list3.add(3);
//        triangle.add(list3);
        System.out.println(minimumTotalV2(triangle));
    }
}
