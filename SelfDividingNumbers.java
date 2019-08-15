package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/6
 */

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    /**
     * 728. Self Dividing Numbers
     * Easy
     * <p>
     * A self-dividing number is a number that is divisible by every digit it contains.
     * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
     * Also, a self-dividing number is not allowed to contain the digit zero.
     * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
     * Example 1:
     * Input:
     * left = 1, right = 22
     * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
     * Note:
     * The boundaries of each input argument are 1 <= left <= right <= 10000.
     */
    public List<Integer> solution(int left, int right) {
        List<Integer> res = new ArrayList<>();
        if (right < left)
            return res;
        for (int i = left; i <= right; i++) {
            boolean flag = false;
            int k = i;
            while (!flag) {
                int km = k % 10;
                k = k / 10;
                if (km > 0 && i % km == 0 && k == 0) {
                    flag = true;
                    break;
                }
                if (km == 0 || i % km != 0)
                    break;
            }
            if (flag)
                res.add(i);
        }
        return res;
    }

    public List<Integer> solution2(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j > 0; j /= 10) {
                if ((j % 10 == 0) || (i % (j % 10) != 0)) break;
            }
            if (j == 0) list.add(i);
        }
        return list;
    }

    public static void main(String[] arg) {
        SelfDividingNumbers s = new SelfDividingNumbers();
        System.out.println(s.solution(1, 22));
    }
}
