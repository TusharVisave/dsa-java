# Merge Two Sorted Linked Lists

## Problem

Given the heads of two sorted linked lists, merge them into one sorted linked list.

The merged list should reuse the existing nodes rather than creating a new set of nodes.

---

## Pattern

**Linked List — Two Pointers**

Compare the current node of both lists and attach the smaller node to the result.

A dummy node is used to simplify the construction of the merged list.

---

## Approach

1. Create a dummy node.
2. Keep a `current` pointer at the dummy node.
3. Compare the current nodes of both lists.
4. Attach the smaller node to `current.next`.
5. Move the selected list pointer forward.
6. Move `current` forward.
7. When one list becomes empty, attach the remaining nodes from the other list.
8. Return `dummy.next`.

---

## Example

```text
List 1: 1 → 3 → 5
List 2: 2 → 4 → 6

Compare:
1 < 2 → take 1
3 > 2 → take 2
3 < 4 → take 3
5 > 4 → take 4
5 < 6 → take 5
take remaining 6

Result:

1 → 2 → 3 → 4 → 5 → 6