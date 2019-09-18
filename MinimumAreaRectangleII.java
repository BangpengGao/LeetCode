package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/9/17
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumAreaRectangleII {
    /**
     * 963. Minimum Area Rectangle II
     * Medium
     * <p>
     * Given a set of points in the xy-plane, determine the minimum area of any rectangle
     * formed from these points,
     * with sides not necessarily parallel to the x and y axes.
     * If there isn't any rectangle, return 0.
     * <p>
     * Example 1:
     * Input: [[1,2],[2,1],[1,0],[0,1]]
     * Output: 2.00000
     * Explanation: The minimum area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an
     * area of 2.
     * <p>
     * Example 2:
     * Input: [[0,1],[2,1],[1,1],[1,0],[2,0]]
     * Output: 1.00000
     * Explanation: The minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an
     * area of 1.
     * <p>
     * Example 3:
     * Input: [[0,3],[1,2],[3,1],[1,3],[2,1]]
     * Output: 0
     * Explanation: There is no possible rectangle to form from these points.
     * <p>
     * Example 4:
     * Input: [[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
     * Output: 2.00000
     * Explanation: The minimum area rectangle occurs at [2,1],[2,3],[3,3],[3,1], with an
     * area of 2.
     * <p>
     * Note:
     * 1 <= points.length <= 50
     * 0 <= points[i][0] <= 40000
     * 0 <= points[i][1] <= 40000
     * All points are distinct.
     * Answers within 10^-5 of the actual value will be accepted as correct.
     */

    // 解决方案：
    // 1、暴力循环遍历
    // 2、如下代码

    public static double solution(int[][] points) {
        int len = points.length;
        Point[] pArr = new Point[len];
        for (int i = 0; i < len; ++i)
            pArr[i] = new Point(points[i][0], points[i][1]);

        Map<Integer, Map<Point, List<Point>>> pMap = new HashMap();
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                Point center = new Point(pArr[i].x + pArr[j].x, pArr[i].y + pArr[j].y);
                int dis = (pArr[i].x - pArr[j].x) * (pArr[i].x - pArr[j].x);
                dis += (pArr[i].y - pArr[j].y) * (pArr[i].y - pArr[j].y);
                if (!pMap.containsKey(dis))
                    pMap.put(dis, new HashMap<Point, List<Point>>());
                if (!pMap.get(dis).containsKey(center))
                    pMap.get(dis).put(center, new ArrayList<>());
                pMap.get(dis).get(center).add(pArr[i]);
            }
        }
        double res = Double.MAX_VALUE;
        for (Map<Point, List<Point>> pm : pMap.values()) {
            for (Point pk : pm.keySet()) {
                List<Point> pl = pm.get(pk);
                int plSize = pl.size();
                for (int i = 0; i < plSize; ++i) {
                    for (int j = i + 1; j < plSize; ++j) {
                        Point x = pl.get(i);
                        Point y = pl.get(j);
                        Point c = new Point(pk);
                        c.translate(-y.x, -y.y);
                        double area = x.distance(y) * x.distance(c);
                        if (area < res)
                            res = area;
                    }
                }
            }
        }
        return res < Double.MAX_VALUE ? res : 0;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0, 3}, {1, 2}, {3, 1}, {1, 3}, {2, 1}};
        System.out.println(solution(input));
    }
}
