# Invert Binary Tree

## Problem

Given the `root` of a binary tree, invert the tree, and return its root.

Inverting a binary tree (also known as mirroring a binary tree) means that for every node in the tree, its left child and right child are swapped.

---

### Examples

#### Example 1

```text
       4                   4
     /   \               /   \
    2     7     ==>     7     2
   / \   / \           / \   / \
  1   3 6   9         9   6 3   1
```

```text
Input: root = [4, 2, 7, 1, 3, 6, 9]
Output: [4, 7, 2, 9, 6, 3, 1]
```

#### Example 2

```text
     2               2
   /   \    ==>    /   \
  1     3         3     1
```

```text
Input: root = [2, 1, 3]
Output: [2, 3, 1]
```

#### Example 3

```text
Input: root = []
Output: []
```

---

## Pattern

**Depth-First Search (DFS / Post-order Traversal) & Breadth-First Search (BFS / Level-order)**

Tree inversion follows a **Divide and Conquer** / **Subtree Decomposition** pattern:
1. To invert any binary tree rooted at `root`:
   - Invert its left subtree.
   - Invert its right subtree.
   - Swap the pointers to the left and right subtrees.
2. The base case is reached when encountering `null` (an empty subtree requires no inversion).

---

## Approaches

### Approach 1: Recursive Depth-First Search (DFS / Post-Order)

1. **Base Case**:
   - If `root == null`, return `null`.
2. **Recursive Step**:
   - Recursively invert the left subtree: `TreeNode left = invertTree(root.left);`
   - Recursively invert the right subtree: `TreeNode right = invertTree(root.right);`
3. **Swap**:
   - Assign `root.left = right;`
   - Assign `root.right = left;`
4. **Return**:
   - Return `root`.

---

### Approach 2: Iterative Breadth-First Search (BFS / Queue)

To prevent `StackOverflowError` in environments with shallow recursion call stacks or deeply skewed trees:
1. If `root == null`, return `null`.
2. Initialize a queue: `Queue<TreeNode> queue = new ArrayDeque<>()` and offer `root`.
3. While the queue is not empty:
   - Poll node `current` from the queue.
   - Swap `current.left` and `current.right`.
   - If `current.left != null`, push to queue.
   - If `current.right != null`, push to queue.
4. Return `root`.

---

## Complexity

### Recursive DFS

* **Time Complexity**: $\mathcal{O}(n)$ — Every node in the binary tree is visited exactly once.
* **Space Complexity**: $\mathcal{O}(h)$ auxiliary call stack space, where $h$ is the height of the tree:
  - **Best / Balanced case**: $\mathcal{O}(\log n)$ for a balanced binary tree.
  - **Worst case**: $\mathcal{O}(n)$ for a completely skewed tree (linked-list shaped).

### Iterative BFS

* **Time Complexity**: $\mathcal{O}(n)$ — Each node is enqueued and dequeued once.
* **Space Complexity**: $\mathcal{O}(w)$ where $w$ is the maximum width of the tree (up to $\mathcal{O}(n)$ at the bottom level of a full binary tree).

---

## Important Edge Cases

1. **Empty Tree (`root == null`)**: Returns `null` immediately without throwing `NullPointerException`.
2. **Single Node Tree**: A tree with only the root has no children to swap and returns the root untouched.
3. **Left-Skewed Tree**: Successfully inverts a degenerate line of left nodes into a right-skewed tree.
4. **Right-Skewed Tree**: Successfully inverts a degenerate line of right nodes into a left-skewed tree.
5. **Asymmetric Trees**: Handles trees where subtrees have unequal depths or missing children without issue.
6. **Negative & Duplicate Values**: Node values do not influence structural pointers; handles all integer ranges including negative values and duplicates.
7. **Double Inversion**: Inverting an inverted tree produces an identical tree to the original input.
