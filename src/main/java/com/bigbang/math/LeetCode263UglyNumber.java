package com.bigbang.math;

/**
 * 263. 丑数
 * 简单
 * 相关标签
 * 相关企业
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
 * <p>
 * 示例 3：
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 * <p>
 * 提示：
 * -231 <= n <= 231 - 1
 *
 * @author Bang Peng
 * @version 1.0.0
 * @date 2024/1/26
 * @since 1.0.0
 */
public class LeetCode263UglyNumber {

    public static boolean isUgly(int n) {
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
        return n == 1;
    }

    /**
     * 当n很大时，采用递归的方法会导致stackOverFlowError
     *
     * @param n 数
     * @return 是否是丑数
     */
    public static boolean isUglyByRecursion(int n) {
        if (n % 2 == 0) {
            return isUglyByRecursion(n / 2);
        }
        if (n % 3 == 0) {
            return isUglyByRecursion(n / 3);
        }
        if (n % 5 == 0) {
            return isUglyByRecursion(n / 5);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(1));
        System.out.println(isUgly(14));
    }

}
