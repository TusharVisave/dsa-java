# Remove Nth Node From End of List

## Problem

Given the head of a linked list, remove the nth node from the end of the list and return the new head.

---

## Pattern

**Linked List — Two Pointers**

Use two pointers with a gap of `n` nodes between them.

A dummy node is used to handle the case where the head itself needs to be removed.

---

## Approach

1. Create a dummy node before the head.
2. Set `fast` and `slow` to the dummy node.
3. Move `fast` forward by `n` nodes.
4. Move both pointers until `fast` reaches the last node.
5. `slow` is now immediately before the node to remove.
6. Skip the target node using `slow.next`.
7. Return `dummy.next`.

---

## Example

```text
Input:

1 → 2 → 3 → 4 → 5
n = 2

The 2nd node from the end is 4.

Output:

1 → 2 → 3 → 5