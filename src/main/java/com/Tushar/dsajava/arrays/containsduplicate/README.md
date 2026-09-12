# Contains Duplicate

## Problem

Given an integer array, determine whether any value appears at least twice.

## Approach

Use a HashSet to store numbers already seen.

- If a number is already present → duplicate found.
- Otherwise, add it to the set.

## Complexity

- Time: O(n)
- Space: O(n)

## Pattern

HashSet / Duplicate Detection