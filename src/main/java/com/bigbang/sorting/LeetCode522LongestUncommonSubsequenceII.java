package com.bigbang.sorting;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @ Created with IntelliJ IDEA
 * @ Author Bang Peng
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2021/9/2
 * @ Time 10:24
 */
public class LeetCode522LongestUncommonSubsequenceII {
    /**
     * Given an array of strings strs, return the length of the longest uncommon subsequence between them.
     * If the longest uncommon subsequence does not exist, return -1.
     * <p>
     * An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.
     * <p>
     * A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.
     * <p>
     * For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc".
     * Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: strs = ["aba","cdc","eae"]
     * Output: 3
     * Example 2:
     * <p>
     * Input: strs = ["aaa","aaa","aa"]
     * Output: -1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 2 <= strs.length <= 50
     * 1 <= strs[i].length <= 10
     * strs[i] consists of lowercase English letters.
     *
     * @param strs
     * @return
     */
    public static int findLUSlength(String[] strs) {
        // 避免进入误区，不是一个字符都不相同，而是子序列不相同
        //Runtime: 1 ms, faster than 98.56% of Java online submissions for Longest Uncommon Subsequence II.
        //Memory Usage: 36.3 MB, less than 96.73% of Java online submissions for Longest Uncommon Subsequence II.
        
        if (strs.length <= 1) return -1;
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String b, String a) {
                return a.length() != b.length() ? a.length() - b.length() : a.compareTo(b);
            }
        });

        if (!strs[1].equals(strs[0]))
            return strs[0].length();

        int cur = 2;
        boolean flag = true;
        while (cur < strs.length) {
            flag = true;
            if (!strs[cur].equals(strs[cur - 1]) && (cur == strs.length - 1 || !strs[cur].equals(strs[cur + 1]))) {
                for (int i = 0; i < cur; i++) {
                    if (isSubsequence(strs[i], strs[cur])) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    return strs[cur].length();
            }
            cur++;
        }
        return -1;
    }

    public static boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) j++;
            i++;
        }
        return j == b.length();
    }

    public static void main(String[] args) {
        String[] strings = {"aaa", "acb"};
        System.out.println(findLUSlength(strings));
    }
}
