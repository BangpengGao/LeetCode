package com.bigbang.old;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/27
 */

import java.util.Arrays;

public class Heaters {
    /**
     * 475. Heaters
     * Easy
     * <p>
     * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm
     * radius to warm all the houses.Now, you are given positions of houses and heaters on a horizontal line,
     * find out minimum radius of heaters so that all houses could be covered by those heaters. So, your input
     * will be the positions of houses and heaters seperately, and your expected output will be the minimum
     * radius standard of heaters.
     * <p>
     * Note:
     * <p>
     * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
     * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
     * As long as a house is in the heaters' warm radius range, it can be warmed.
     * All the heaters follow your radius standard and the warm radius will the same.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3],[2]
     * Output: 1
     * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then
     * all the houses can be warmed.
     * <p>
     * Example 2:
     * <p>
     * Input: [1,2,3,4],[1,4]
     * Output: 1
     * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then
     * all the houses can be warmed.
     */

    /**
     * 解题思路
     * ①找到热水器之间每个房间的位置
     * ②计算该房间到左边热水器的距离和到右边热水器的距离，获取两个距离中的最小值
     * ③得到②步骤中的最大值
     */
    public static int solution(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5}, new int[]{2}));
    }
}
