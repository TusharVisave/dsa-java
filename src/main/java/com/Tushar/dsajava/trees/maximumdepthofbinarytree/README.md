# Maximum Depth of Binary Tree

## Problem

Given the `root` of a binary tree, return its **maximum depth**.

A binary tree's **maximum depth** is the number of nodes along the longest path from the root node down to the farthest leaf node.

---

### Examples

#### Example 1

```text
       3
     /   \
    9     20
         /  \
        15   7
```

```text
Input: root = [3, 9, 20, null, null, 15, 7]
Output: 3
Explanation: The longest path is 3 -> 20 -> 15 (or 7), which has 3 nodes.
```

#### Example 2

```text
    1
     \
      2
```

```text
Input: root = [1, null, 2]
Output: 2
```

#### Example 3

```text
Input: root = []
Output: 0
```

---

## Pattern

**Depth-First Search (DFS / Post-order Traversal) & Breadth-First Search (BFS / Level-Order Traversal)**

Computing tree height or depth fundamentally builds on tree traversal patterns:
1. **DFS (Divide & Conquer)**:
   - The depth of a tree rooted at node `u` is `1 + max(depth(left), depth(right))`.
   - The base case is `null`, which has depth `0`.
2. **BFS (Level-Order Traversal)**:
   - Traverse the tree level by level using a FIFO queue.
   - Increment the depth counter after completely consuming all nodes belonging to the current level (`queue.size()`).

---

## Approaches

### Approach 1: Recursive Depth-First Search (DFS / Post-Order) — Preferred for Simplicity

1. **Base Case**:
   - If `root == null`, return `0`.
2. **Recursive Step**:
   - Compute depth of left subtree: `int leftDepth = maxDepth(root.left);`
   - Compute depth of right subtree: `int rightDepth = maxDepth(root.right);`
3. **Combine**:
   - Return `1 + Math.max(leftDepth, rightDepth)`.

---

### Approach 2: Iterative Breadth-First Search (BFS / Queue) — Level-by-Level

To traverse level by level without recursion overhead:
1. If `root == null`, return `0`.
2. Initialize `Queue<TreeNode> queue = new ArrayDeque<>()`, offer `root`, and set `depth = 0`.
3. While `!queue.isEmpty()`:
   - Record current level size: `int levelSize = queue.size()`.
   - Increment `depth++`.
   - Iterate `levelSize` times:
     - Poll node `curr`.
     - Enqueue `curr.left` and `curr.right` if non-null.
4. Return `depth`.

---

### Approach 3: Iterative Depth-First Search (Explicit Stack)

Uses an explicit stack pairing nodes with their respective depths to eliminate recursion limit vulnerabilities on degenerate trees:
1. Maintain two parallel stacks (or a custom Pair object): `nodeStack` and `depthStack`.
2. Push `(root, 1)`.
3. While stack is not empty, pop `(node, currentDepth)`:
   - Update `maxDepth = Math.max(maxDepth, currentDepth)`.
   - Push children with `currentDepth + 1`.
4. Return `maxDepth`.

---

## Complexity

| Approach | Time Complexity | Space Complexity | Notes |
| :--- | :---: | :---: | :--- |
| **Recursive DFS** | $\mathcal{O}(n)$ | $\mathcal{O}(h)$ | $h = \mathcal{O}(\log n)$ balanced, $\mathcal{O}(n)$ skewed (call stack) |
| **Iterative BFS** | $\mathcal{O}(n)$ | $\mathcal{O}(w)$ | $w \le \lceil n/2 \rceil$ (maximum width of the tree) |
| **Iterative DFS** | $\mathcal{O}(n)$ | $\mathcal{O}(h)$ | Explicit heap stack avoids call stack exhaustion |

- **$n$**: Total number of nodes in the binary tree.
- **$h$**: Height of the tree ($\log_2 n \le h \le n$).
- **$w$**: Maximum width (number of nodes on the fullest level).

---

## Important Edge Cases

1. **Empty Tree (`root == null`)**: Returns `0` immediately.
2. **Single Node Tree (`root != null, left == null, right == null`)**: Returns `1`.
3. **Left-Skewed Tree**: Height equals $n$; verified to avoid stack overflow or infinite loops.
4. **Right-Skewed Tree**: Height equals $n$; properly navigates right-only chains.
5. **Zig-Zag Tree**: Alternating left and right single children correctly increments depth at each tier.
6. **Asymmetric / Unbalanced Subtrees**: Left subtree significantly deeper than right (or vice versa); takes the maximum rather than sum or average.
7. **Negative and Zero Node Values**: Node values do not influence tree depth calculation.
