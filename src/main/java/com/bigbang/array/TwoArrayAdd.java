package com.bigbang.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2023/1/31
 * @since 1.0.0
 */
public class TwoArrayAdd {

    public static List<Integer> solution(int[] l1, int[] l2) {
        int maxLen = Math.max(l1.length, l2.length);
        List<Integer> res = new ArrayList<>(maxLen + 1);
        int li1 = 0, li2 = 0, flag = 0;
        while (li1 < l1.length && li2 < l2.length) {
            int sum = l1[li1] + l2[li2] + flag;
            res.add(sum % 10);
            flag = sum / 10;
            li1++;
            li2++;
        }
        while (li1 < l1.length) {
            int sum = l1[li1] + flag;
            res.add(sum % 10);
            flag = sum / 10;
            li1++;
        }
        while (li2 < l2.length) {
            int sum = l2[li2] + flag;
            res.add(sum % 10);
            flag = sum / 10;
            li2++;
        }
        if (flag > 0)
            res.add(flag);
        return res;
    }

    public static void main(String[] args) {
        int[] l1 = {2, 4, 3};
        int[] l2 = {5, 6, 4};
        System.out.println(solution(l1, l2));
        int[] l3 = {0};
        int[] l4 = {0};
        System.out.println(solution(l3, l4));
        int[] l5 = {9, 9, 9, 9, 9, 9, 9};
        int[] l6 = {9, 9, 9, 9};
        System.out.println(solution(l5, l6));
    }
}
