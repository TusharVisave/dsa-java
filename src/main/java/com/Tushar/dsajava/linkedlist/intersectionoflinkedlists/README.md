# Intersection of Two Linked Lists

## Problem

Given the heads of two singly linked lists, determine the node at which
the two lists intersect.

If the lists do not intersect, return `null`.

The intersection is based on node reference, not node value.

---

## Pattern

Two Pointers — Pointer Switching

---

## Approach

Use two pointers:

- `pointerA` starts at `headA`.
- `pointerB` starts at `headB`.
- Move both pointers one node at a time.
- When a pointer reaches the end of its list, move it to the head of the
  other list.
- Continue until both pointers reference the same node.

The pointers eventually travel the same total distance:

```text
Length(A) + Length(B)