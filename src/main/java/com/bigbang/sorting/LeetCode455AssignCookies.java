package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/31
 * @ Time 14:29
 */
public class LeetCode455AssignCookies {
    /**
     * Assume you are an awesome parent and want to give your children some cookies.
     * But, you should give each child at most one cookie.
     * <p>
     * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
     * and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i,
     * and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: g = [1,2,3], s = [1,1]
     * Output: 1
     * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
     * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
     * You need to output 1.
     * Example 2:
     * <p>
     * Input: g = [1,2], s = [1,2,3]
     * Output: 2
     * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
     * You have 3 cookies and their sizes are big enough to gratify all of the children,
     * You need to output 2.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= g.length <= 3 * 104
     * 0 <= s.length <= 3 * 104
     * 1 <= g[i], s[j] <= 231 - 1
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        //Runtime: 9 ms, faster than 23.43% of Java online submissions for Assign Cookies.
        //Memory Usage: 50.2 MB, less than 5.15% of Java online submissions for Assign Cookies.

        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0, gIdx = 0, sIdx = 0;
        while (gIdx < g.length && sIdx < s.length) {
            if (g[gIdx] > s[sIdx])
                sIdx++;
            else {
                count++;
                gIdx++;
                sIdx++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3}, s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }
}
