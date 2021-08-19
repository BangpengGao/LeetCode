package com.leetcode;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/15
 */

public class InsertIntoABinarySearchTree {
    /**
     * 701. Insert into a Binary Search Tree
     * Medium
     *
     * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
     * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
     *
     * For example,
     * Given the tree:
     *         4
     *        / \
     *       2   7
     *      / \
     *     1   3
     * And the value to insert: 5
     * You can return this binary search tree:
     *          4
     *        /   \
     *       2     7
     *      / \   /
     *     1   3 5
     * This tree is also valid:
     *
     *          5
     *        /   \
     *       2     7
     *      / \
     *     1   3
     *          \
     *           4
     */

    public TreeNode solution1(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode curNode = root;
        while (true) {
            if (curNode.val < val) {
                if (curNode.right == null) {
                    curNode.right = new TreeNode(val);
                    return root;
                } else {
                    curNode = curNode.right;
                }
            } else{
                if (curNode.left == null) {
                    curNode.left = new TreeNode(val);
                    return root;
                } else {
                    curNode = curNode.left;
                }
            }
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
