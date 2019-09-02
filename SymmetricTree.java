package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/30
 */

public class SymmetricTree {
    /**
     * 101. Symmetric Tree
     * Easy
     * <p>
     * 2575
     * <p>
     * 56
     * <p>
     * Favorite
     * <p>
     * Share
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * <p>
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     * <p>
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * <p>
     * <p>
     * But the following [1,2,2,null,3,null,3] is not:
     * <p>
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     * <p>
     * <p>
     * Note:
     * Bonus points if you could solve it both recursively and iteratively.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean solution(TreeNode root) {
        if (root == null) return true;
        return judgeIsSymmetric(root.left, root.right);
    }

    public boolean judgeIsSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && judgeIsSymmetric(left.left, right.right) && judgeIsSymmetric(right.left, left.right);
    }
}
