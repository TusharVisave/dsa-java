package com.Tushar.dsajava.trees.invertbinarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Invert Binary Tree Tests")
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Should return null for empty tree")
    void shouldReturnNullForEmptyTree() {
        assertNull(solution.invertTree(null));
        assertNull(solution.invertTreeIterative(null));
    }

    @Test
    @DisplayName("Should return single node untouched")
    void shouldHandleSingleNode() {
        TreeNode root = new TreeNode(42);

        TreeNode result = solution.invertTree(root);

        assertNotNull(result);
        assertEquals(42, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    @DisplayName("Should invert standard 3-node binary tree")
    void shouldInvertThreeNodeTree() {
        // Tree:
        //     2
        //    / \
        //   1   3
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        TreeNode inverted = solution.invertTree(root);

        // Expected:
        //     2
        //    / \
        //   3   1
        assertEquals(2, inverted.val);
        assertEquals(3, inverted.left.val);
        assertEquals(1, inverted.right.val);
    }

    @Test
    @DisplayName("Should invert standard 7-node complete binary tree (LeetCode Example 1)")
    void shouldInvertCompleteSevenNodeTree() {
        // Tree:
        //        4
        //      /   \
        //     2     7
        //    / \   / \
        //   1   3 6   9
        TreeNode root = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );

        TreeNode inverted = solution.invertTree(root);

        // Expected:
        //        4
        //      /   \
        //     7     2
        //    / \   / \
        //   9   6 3   1
        assertEquals(4, inverted.val);
        assertEquals(7, inverted.left.val);
        assertEquals(2, inverted.right.val);

        assertEquals(9, inverted.left.left.val);
        assertEquals(6, inverted.left.right.val);
        assertEquals(3, inverted.right.left.val);
        assertEquals(1, inverted.right.right.val);
    }

    @Test
    @DisplayName("Should invert left-skewed tree into right-skewed tree")
    void shouldInvertLeftSkewedTree() {
        // Tree:
        //     1
        //    /
        //   2
        //  /
        // 3
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);

        TreeNode inverted = solution.invertTree(root);

        // Expected:
        // 1
        //  \
        //   2
        //    \
        //     3
        assertEquals(1, inverted.val);
        assertNull(inverted.left);
        assertNotNull(inverted.right);
        assertEquals(2, inverted.right.val);
        assertNull(inverted.right.left);
        assertNotNull(inverted.right.right);
        assertEquals(3, inverted.right.right.val);
    }

    @Test
    @DisplayName("Should invert right-skewed tree into left-skewed tree")
    void shouldInvertRightSkewedTree() {
        // Tree:
        // 1
        //  \
        //   2
        //    \
        //     3
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));

        TreeNode inverted = solution.invertTree(root);

        // Expected:
        //     1
        //    /
        //   2
        //  /
        // 3
        assertEquals(1, inverted.val);
        assertNull(inverted.right);
        assertNotNull(inverted.left);
        assertEquals(2, inverted.left.val);
        assertNull(inverted.left.right);
        assertNotNull(inverted.left.left);
        assertEquals(3, inverted.left.left.val);
    }

    @Test
    @DisplayName("Should handle tree with negative numbers and zero")
    void shouldHandleNegativeNumbersAndZero() {
        // Tree:
        //       0
        //     /   \
        //   -5     10
        //   /
        // -15
        TreeNode root = new TreeNode(
                0,
                new TreeNode(-5, new TreeNode(-15), null),
                new TreeNode(10)
        );

        TreeNode inverted = solution.invertTree(root);

        assertEquals(0, inverted.val);
        assertEquals(10, inverted.left.val);
        assertEquals(-5, inverted.right.val);
        assertNull(inverted.right.left);
        assertEquals(-15, inverted.right.right.val);
    }

    @Test
    @DisplayName("Should restore original tree when inverted twice (Idempotence property)")
    void shouldRestoreTreeWhenInvertedTwice() {
        TreeNode original = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );

        TreeNode invertedOnce = solution.invertTree(original);
        TreeNode invertedTwice = solution.invertTree(invertedOnce);

        assertEquals(4, invertedTwice.val);
        assertEquals(2, invertedTwice.left.val);
        assertEquals(7, invertedTwice.right.val);
        assertEquals(1, invertedTwice.left.left.val);
        assertEquals(3, invertedTwice.left.right.val);
        assertEquals(6, invertedTwice.right.left.val);
        assertEquals(9, invertedTwice.right.right.val);
    }

    @Test
    @DisplayName("Iterative BFS should produce identical result to recursive DFS")
    void iterativeShouldMatchRecursiveResult() {
        TreeNode tree1 = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );

        TreeNode tree2 = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );

        TreeNode recursiveResult = solution.invertTree(tree1);
        TreeNode iterativeResult = solution.invertTreeIterative(tree2);

        assertTrue(areTreesEqual(recursiveResult, iterativeResult));
    }

    private boolean areTreesEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return areTreesEqual(t1.left, t2.left) && areTreesEqual(t1.right, t2.right);
    }
}
