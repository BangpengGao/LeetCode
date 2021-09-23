package com.bigbang.dynamicprogramming;

import java.util.Stack;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/23
 * @since 1.0.0
 */
public class LeetCode42TrappingRainWater {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it can trap after raining.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
     * In this case, 6 units of rain water (blue section) are being trapped.
     * <p>
     * Example 2:
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     * <p>
     * Constraints:
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        //动态规划
        //Runtime: 1 ms, faster than 88.79% of Java online submissions for Trapping Rain Water.
        //Memory Usage: 38.6 MB, less than 64.33% of Java online submissions for Trapping Rain Water.

        int solution = 0, len = height.length;
        int[] leftHeight = new int[len], rightHeight = new int[len];
        leftHeight[0] = height[0];
        rightHeight[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightHeight[i] = Math.max(height[i], rightHeight[i + 1]);
        }
        for (int i = 0; i < len; i++) {
            solution += Math.min(leftHeight[i], rightHeight[i]) - height[i];
        }
        return solution;
    }

    public static int trapWithStack(int[] height) {
        //采用堆栈暂存的方式
        //Runtime: 3 ms, faster than 20.02% of Java online submissions for Trapping Rain Water.
        //Memory Usage: 38.7 MB, less than 54.69% of Java online submissions for Trapping Rain Water.

        int solution = 0, current = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.peek();
                stack.pop();
                if (stack.empty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                solution += distance * bounded_height;
            }
            stack.push(current++);
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
        System.out.println(trapWithStack(height));
    }
}
