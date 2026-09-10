# Maximum Subarray

## Problem

Given an integer array, find the contiguous subarray with the largest sum.

## Approach

Use Kadane's Algorithm.

Maintain the maximum sum of a subarray ending at the current position.

At every element, decide whether to start a new subarray or extend the previous subarray.

The current sum is calculated as:

`max(current element, current sum + current element)`

The maximum sum is updated whenever a larger value is found.

## Why this approach?

A brute-force approach checks multiple possible subarrays and requires more than O(n) time.

Kadane's Algorithm processes every element once.

It therefore reduces the time complexity to O(n) while using constant extra space.

## Time Complexity

O(n)

## Space Complexity

O(1)

## Edge Cases

- Empty array.
- Single element.
- All elements are negative.
- All elements are positive.
- Array contains both positive and negative numbers.