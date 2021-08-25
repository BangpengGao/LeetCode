package com.bigbang.sorting;

import java.util.Arrays;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/8/24
 * @ Time 13:28
 */
public class LeetCode274HIndex {
    /**
     * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
     * return compute the researcher's h-index.
     * <p>
     * According to the definition of h-index on Wikipedia:
     * A scientist has an index h if h of their n papers have at least h citations each,
     * and the other n − h papers have no more than h citations each.
     * <p>
     * If there are several possible values for h, the maximum one is taken as the h-index.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: citations = [3,0,6,1,5]
     * Output: 3
     * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
     * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
     * Example 2:
     * <p>
     * Input: citations = [1,3,1]
     * Output: 1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == citations.length
     * 1 <= n <= 5000
     * 0 <= citations[i] <= 1000
     *
     * @param citations
     * @return
     */
    public static int hIndex(int[] citations) {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for H-Index.
        //Memory Usage: 37.2 MB, less than 27.03% of Java online submissions for H-Index.

        Arrays.sort(citations);
        int len = citations.length;
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len - i)
                return len - i;
        }
        return 0;
    }

    public static int hIndexV2(int[] citations) {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for H-Index.
        //Memory Usage: 37.1 MB, less than 27.03% of Java online submissions for H-Index.

        int len = citations.length;
        int[] buckets = new int[len + 1];
        for (int citation : citations) {
            if (citation >= len) {
                buckets[len]++;
            } else {
                buckets[citation]++;
            }
        }

        int count = 0;
        for (int i = len; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) return i;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1, 3, 1}));
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
