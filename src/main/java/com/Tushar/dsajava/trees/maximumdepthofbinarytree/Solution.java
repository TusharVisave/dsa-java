package com.Tushar.dsajava.trees.maximumdepthofbinarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Problem 21: Maximum Depth of Binary Tree (LeetCode 104).
 *
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 */
public class Solution {

    /**
     * Calculates the maximum depth of a binary tree using recursive Depth-First Search (DFS / Post-order).
     *
     * <p>Divide and Conquer recurrence:
     * {@code maxDepth(root) = 1 + Math.max(maxDepth(root.left), maxDepth(root.right))}
     *
     * @param root the root node of the binary tree
     * @return the maximum depth of the tree, or 0 if the tree is empty
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * Calculates the maximum depth of a binary tree using iterative Breadth-First Search (BFS / Level-order).
     *
     * <p>Processes the tree level by level using a FIFO queue. Each iteration of the outer
     * loop drains an entire level of size {@code queue.size()} and increments the depth counter.
     *
     * @param root the root node of the binary tree
     * @return the maximum depth of the tree, or 0 if the tree is empty
     */
    public int maxDepthBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return depth;
    }

    /**
     * Calculates the maximum depth of a binary tree using iterative Depth-First Search (DFS)
     * with an explicit stack to prevent recursion call stack overflow on deep/skewed trees.
     *
     * @param root the root node of the binary tree
     * @return the maximum depth of the tree, or 0 if the tree is empty
     */
    public int maxDepthDfsIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> depthStack = new ArrayDeque<>();

        nodeStack.push(root);
        depthStack.push(1);
        int maxDepth = 0;

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int currentDepth = depthStack.pop();

            maxDepth = Math.max(maxDepth, currentDepth);

            if (node.left != null) {
                nodeStack.push(node.left);
                depthStack.push(currentDepth + 1);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                depthStack.push(currentDepth + 1);
            }
        }

        return maxDepth;
    }
}
