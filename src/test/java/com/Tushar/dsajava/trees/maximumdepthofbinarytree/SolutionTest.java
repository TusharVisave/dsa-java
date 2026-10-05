package com.Tushar.dsajava.trees.maximumdepthofbinarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Maximum Depth of Binary Tree Tests")
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Should return 0 for empty tree")
    void shouldReturnZeroForNullTree() {
        assertEquals(0, solution.maxDepth(null));
        assertEquals(0, solution.maxDepthBfs(null));
        assertEquals(0, solution.maxDepthDfsIterative(null));
    }

    @Test
    @DisplayName("Should return 1 for single node tree")
    void shouldReturnOneForSingleNode() {
        TreeNode root = new TreeNode(10);

        assertEquals(1, solution.maxDepth(root));
        assertEquals(1, solution.maxDepthBfs(root));
        assertEquals(1, solution.maxDepthDfsIterative(root));
    }

    @Test
    @DisplayName("Should return 2 for root with only left child")
    void shouldReturnTwoForLeftChildOnly() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);

        assertEquals(2, solution.maxDepth(root));
        assertEquals(2, solution.maxDepthBfs(root));
        assertEquals(2, solution.maxDepthDfsIterative(root));
    }

    @Test
    @DisplayName("Should return 2 for root with only right child (LeetCode Example 2)")
    void shouldReturnTwoForRightChildOnly() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));

        assertEquals(2, solution.maxDepth(root));
        assertEquals(2, solution.maxDepthBfs(root));
        assertEquals(2, solution.maxDepthDfsIterative(root));
    }

    @Test
    @DisplayName("Should return 2 for balanced 3-node binary tree")
    void shouldReturnTwoForBalancedThreeNodeTree() {
        // Tree:
        //     2
        //    / \
        //   1   3
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        assertEquals(2, solution.maxDepth(root));
        assertEquals(2, solution.maxDepthBfs(root));
        assertEquals(2, solution.maxDepthDfsIterative(root));
    }

    @Test
    @DisplayName("Should calculate depth 3 for LeetCode Example 1")
    void shouldCalculateDepthForLeetCodeExampleOne() {
        // Tree:
        //        3
        //      /   \
        //     9     20
        //          /  \
        //         15   7
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        assertEquals(3, solution.maxDepth(root));
        assertEquals(3, solution.maxDepthBfs(root));
        assertEquals(3, solution.maxDepthDfsIterative(root));
    }

    @Test
    @DisplayName("Should calculate depth for strictly left-skewed tree")
    void shouldCalculateDepthForLeftSkewedTree() {
        // 1 -> 2 -> 3 -> 4 -> 5 (all left)
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4,
                                        new TreeNode(5), null), null), null), null);

        assertEquals(5, solution.maxDepth(root));
        assertEquals(5, solution.maxDepthBfs(root));
        assertEquals(5, solution.maxDepthDfsIterative(root));
    }

    @Test
    @DisplayName("Should calculate depth for strictly right-skewed tree")
    void shouldCalculateDepthForRightSkewedTree() {
        // 1 -> 2 -> 3 -> 4 -> 5 (all right)
        TreeNode root = new TreeNode(1, null,
                new TreeNode(2, null,
                        new TreeNode(3, null,
                                new TreeNode(4, null,
                                        new TreeNode(5)))));

        assertEquals(5, solution.maxDepth(root));
        assertEquals(5, solution.maxDepthBfs(root));
        assertEquals(5, solution.maxDepthDfsIterative(root));
    }

    @Test
    @DisplayName("Should calculate depth for zig-zag tree")
    void shouldCalculateDepthForZigZagTree() {
        // Tree:
        //     1
        //    /
        //   2
        //    \
        //     3
        //    /
        //   4
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(3,
                                new TreeNode(4),
                                null)),
                null);

        assertEquals(4, solution.maxDepth(root));
        assertEquals(4, solution.maxDepthBfs(root));
        assertEquals(4, solution.maxDepthDfsIterative(root));
    }

    @Test
    @DisplayName("Should handle asymmetric tree with deeper left subtree")
    void shouldHandleDeeperLeftSubtree() {
        // Left subtree has depth 4, right subtree has depth 2
        TreeNode leftSubtree = new TreeNode(2,
                new TreeNode(4, new TreeNode(7), null),
                new TreeNode(5));
        TreeNode rightSubtree = new TreeNode(3, null, new TreeNode(6));
        TreeNode root = new TreeNode(1, leftSubtree, rightSubtree);

        assertEquals(4, solution.maxDepth(root));
        assertEquals(4, solution.maxDepthBfs(root));
        assertEquals(4, solution.maxDepthDfsIterative(root));
    }

    @Test
    @DisplayName("Should handle tree with negative numbers and zeroes")
    void shouldHandleNegativeNumbersAndZeroes() {
        TreeNode root = new TreeNode(
                0,
                new TreeNode(-10, new TreeNode(-20), null),
                new TreeNode(10, null, new TreeNode(20, new TreeNode(30), null))
        );

        assertEquals(4, solution.maxDepth(root));
        assertEquals(4, solution.maxDepthBfs(root));
        assertEquals(4, solution.maxDepthDfsIterative(root));
    }

    @Test
    @DisplayName("All approaches (DFS recursive, BFS iterative, DFS iterative) should produce identical results")
    void allApproachesShouldProduceIdenticalResults() {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2,
                        new TreeNode(4, new TreeNode(8), null),
                        new TreeNode(5)),
                new TreeNode(3,
                        null,
                        new TreeNode(6, null, new TreeNode(7)))
        );

        int recursiveResult = solution.maxDepth(root);
        int bfsResult = solution.maxDepthBfs(root);
        int dfsIterativeResult = solution.maxDepthDfsIterative(root);

        assertEquals(4, recursiveResult);
        assertEquals(recursiveResult, bfsResult);
        assertEquals(recursiveResult, dfsIterativeResult);
    }
}
