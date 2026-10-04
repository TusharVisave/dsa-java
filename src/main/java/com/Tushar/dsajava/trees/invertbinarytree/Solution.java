package com.Tushar.dsajava.trees.invertbinarytree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Problem 20: Invert Binary Tree (LeetCode 226).
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 * Inverting a binary tree swaps the left and right subtrees of every node.
 */
public class Solution {

    /**
     * Recursively inverts a binary tree using Depth-First Search (DFS / Post-order).
     *
     * @param root the root node of the binary tree
     * @return the root node of the inverted binary tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    /**
     * Iteratively inverts a binary tree using Breadth-First Search (BFS / Level-order).
     * This avoids recursion call stack overhead and prevents StackOverflowError on deep trees.
     *
     * @param root the root node of the binary tree
     * @return the root node of the inverted binary tree
     */
    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return root;
    }
}
