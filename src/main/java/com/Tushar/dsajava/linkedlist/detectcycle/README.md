# Detect Cycle in Linked List

## Problem

Given the head of a linked list, determine whether the linked list contains a cycle.

A cycle exists when a node's `next` pointer points to a previous node instead of eventually reaching `null`.

---

## Pattern

**Linked List — Fast and Slow Pointers**

Use two pointers:

- `slow` moves one node at a time.
- `fast` moves two nodes at a time.

If a cycle exists, the two pointers will eventually meet.

---

## Approach

1. Initialize `slow` and `fast` at the head.
2. Move `slow` one step.
3. Move `fast` two steps.
4. If `slow == fast`, a cycle exists.
5. If `fast == null` or `fast.next == null`, no cycle exists.
6. Return the result.

---

## Example

```text
1 → 2 → 3 → 4
    ↑       ↓
    └───────┘