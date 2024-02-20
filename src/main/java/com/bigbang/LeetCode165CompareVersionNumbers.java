package com.bigbang;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2023/7/28
 * @since 1.0.0
 */
public class LeetCode165CompareVersionNumbers {
    /**
     * Given two version numbers, version1 and version2, compare them.
     * Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
     * To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
     * Return the following:
     * If version1 < version2, return -1.
     * If version1 > version2, return 1.
     * Otherwise, return 0.
     *
     *
     * Example 1:
     * Input: version1 = "1.01", version2 = "1.001"
     * Output: 0
     * Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
     * Example 2:
     * Input: version1 = "1.0", version2 = "1.0.0"
     * Output: 0
     * Explanation: version1 does not specify revision 2, which means it is treated as "0".
     * Example 3:
     * Input: version1 = "0.1", version2 = "1.1"
     * Output: -1
     * Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
     *
     * Constraints:
     * 1 <= version1.length, version2.length <= 500
     * version1 and version2 only contain digits and '.'.
     * version1 and version2 are valid version numbers.
     * All the given revisions in version1 and version2 can be stored in a 32-bit integer.
     */

    /**
     * Runtime
     * Details
     * 1ms
     * Beats 83.28%of users with Java
     * Memory
     * Details
     * 40.27mb
     * Beats 96.14%of users with Java
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int v1len = v1.length;
        int v2len = v2.length;
        while (i < v1len && i < v2len) {
            if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i]))
                return 1;
            else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i]))
                return -1;
            else
                i++;
        }
        while (i < v1len) {
            if (Integer.parseInt(v1[i]) > 0)
                return 1;
            i++;
        }
        while (i < v2len) {
            if (Integer.parseInt(v2[i]) > 0)
                return -1;
            i++;
        }
        return 0;
    }

    public static int compareVersionV2(String version1, String version2) {
        version1 = version1.replaceAll("\\.0*", "");
        version2 = version2.replaceAll("\\.0*", "");
        int v1len = version1.length();
        int v2len = version2.length();
        if (v1len > v2len) {
            return c(version2, version1, v2len, true, -1);
        } else if (v1len < v2len) {
            return c(version1, version2, v2len, true, 1);
        } else
            return c(version1, version2, v2len, false, 1);
    }

    private static int c(String v1, String v2, int len, boolean eq, int coef) {
        String v2p = v2.substring(0, len);
        long l1 = Long.parseLong(v1);
        long l2p = Long.parseLong(v2p);
        if (l1 > l2p) return coef;
        else if (l2p > l1) return -1 * coef;

        if (eq) {
            String v2s = v2.substring(v1.length());
            if (Long.parseLong(v2s) > 0) return -1 * coef;
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersionV2("01", "1"));
    }
}
