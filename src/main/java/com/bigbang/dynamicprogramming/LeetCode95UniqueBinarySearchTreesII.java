package com.bigbang.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/9/30
 * @since 1.0.0
 */
public class LeetCode95UniqueBinarySearchTreesII {
    /**
     * Given an integer n, return all the structurally unique BST's (binary search trees),
     * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
     * <p>
     * <p>
     * Example 1:
     * Input: n = 3
     * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
     * <p>
     * Example 2:
     * Input: n = 1
     * Output: [[1]]
     * <p>
     * <p>
     * Constraints:
     * 1 <= n <= 8
     */
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        //采用DFS的方式
        //Runtime: 1 ms, faster than 95.74% of Java online submissions for Unique Binary Search Trees II.
        //Memory Usage: 39.3 MB, less than 94.68% of Java online submissions for Unique Binary Search Trees II.

        if (n == 0)
            return new ArrayList<>();
        return dfs(1, n);
    }

    public static List<TreeNode> dfs(int s, int e) {
        List<TreeNode> solution = new ArrayList<>();

        // 左边或右边无数可以作为node，那么此时的node应该为null
        if (s > e) {
            solution.add(null);
            return solution;
        }

        //选其中一个数为root，那么因为是sorted number， 左右树分别只在选中数的左右两边
        for (int i = s; i <= e; i++) {
            List<TreeNode> left = dfs(s, i - 1);
            List<TreeNode> right = dfs(i + 1, e);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    solution.add(new TreeNode(i, l, r));
                }
            }
        }
        return solution;
    }

    public static List<TreeNode> generateTreesV2(int n) {
        //采用动态规划，result列表中存在，从长度0-n所产生的所有可能的node数组，所以最终返回result的n位置的数据
        //Runtime: 1 ms, faster than 95.74% of Java online submissions for Unique Binary Search Trees II.
        //Memory Usage: 39 MB, less than 97.17% of Java online submissions for Unique Binary Search Trees II.

        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<>();
        if (n == 0) {
            return result[0];
        }

        result[0].add(null);
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
        System.out.println(generateTreesV2(3));
    }
}
